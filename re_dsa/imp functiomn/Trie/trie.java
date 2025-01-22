import java.util.*;


class Node{
    Node a[] = new Node[26];
    boolean flag = false;

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
}


public class trie {

    private static Node root;

    public trie(){
        root = new Node();
    }

    public void insert(String word){ // tc -> O(n) where n is length of word
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!node.containskey(c)){
                node.put(c,new Node()); // adding new node reference
            }
            node = node.get(c); // moving to next node
        }
        node.flag = true; // marking end of word
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

    public boolean startsWith(String prefix){ // tc -> O(n) where n is length of word
        Node node = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(!node.containskey(c)){
                return false;
            }
            node = node.get(c);
        }
        return true;
    }
    


    public static void main(String[] args) {
        trie t = new trie();
        t.insert("apple");
        System.out.println(t.search("apple"));   // returns true
        System.out.println(t.search("app"));     // returns false
        System.out.println(t.startsWith("app")); // returns true
        t.insert("app");   
        System.out.println(t.search("app"));     // returns true
    }
}