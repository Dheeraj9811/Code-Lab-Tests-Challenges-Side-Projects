
// question 3093. Longest Common Suffix Queries

import java.lang.reflect.Array;
import java.util.ArrayList;


class pair{
    ArrayList<Integer> index;
    int count;

    pair(ArrayList<Integer> index,int count){
        this.index = index;
        this.count = count;
    }
}
class Node{
    Node a[] = new Node[26];
    boolean flag = false;
    ArrayList<Integer> index = new ArrayList<>();
    

    public Node(){
        // for(int i=0;i<26;i++){
        //     a[i] = null;
        // }
    }

    boolean containskey(char c){
        return a[c-'a']!=null;
    }

    Node get(char c){
        return a[c-'a'];
    
    }

    void put(char c,Node nextnode){
        a[c-'a'] = nextnode;
    }

    boolean isEnd(){
        return flag;
    }


    // return ArrayList of indices
    ArrayList<Integer> getIndices(){
        return index;
    }
}

class trie {

    private static Node root;
    int total;

    public trie(){
        root = new Node();
        total = 0;
    }

    public void insert(String word){ // tc -> O(n) where n is length of word
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!node.containskey(c)){
                node.put(c,new Node()); // adding new node reference
            }
            node = node.get(c); // moving to next node
            node.index.add(total);  // adding index of word means konse number string se aaya hai
        }
        node.flag = true; // marking end of word
        total++;
    }

    public boolean search(String word){ // tc -> O(n) where n is length of word
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!node.containskey(c)){
                return false;
            }
            node = node.get(c);
        }
        return node.isEnd();
    }

    public pair startsWith(String prefix){ // tc -> O(n) where n is length of word
        Node node = root;
        int i = 0;
        for(;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(!node.containskey(c)){
                break;
            }
            node = node.get(c);
        }
        return new pair(node.getIndices(),i+1);
    }


}

public class Solution {

    // reverse the string
    public String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        // 
        trie t = new trie();
        for(String word:wordsContainer){
            t.insert(reverse(word));
        }

        int ans[] = new int[wordsQuery.length];
        for(int i=0;i<wordsQuery.length;i++){
            pair p = t.startsWith(reverse(wordsQuery[i]));
            int count = p.count;
            
            ArrayList<Integer> index = p.index;

            
            if(index.size()>0){
                int max = index.get(0);
                int minsize = wordsContainer[index.get(0)].length();
                // ind the string that is the smallest in length. If there are two or more such strings that have the same smallest length, find the one that occurred earlier in wordsContainer.
                for(int j=0;j<index.size();j++){
                    int size = wordsContainer[index.get(j)].length();
                    if(size<minsize){
                        minsize = size;
                        max = index.get(j);
                    }
                    else if( j !=0 && size==minsize){
                        max = Math.min(max,index.get(0));
                        break;
                    }
                }


                ans[i] = max;
            }
            else ans[i] = 1;
            
        }

        return ans;

    }

    public static void main(String[] args) {
        // Input: wordsContainer = ["abcd","bcd","xbcd"], wordsQuery = ["cd","bcd","xyz"]

        String wordsContainer[] = {"abcd","bcd","xbcd"};
        String wordsQuery[] = {"cd","bcd","xyz"};
        Solution s = new Solution();
        int ans[] = s.stringIndices(wordsContainer,wordsQuery);
        for(int i:ans){
            System.out.print(i+" ");
        }

    }
}
