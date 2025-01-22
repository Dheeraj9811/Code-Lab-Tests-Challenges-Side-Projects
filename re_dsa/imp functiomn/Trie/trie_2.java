import java.util.*;

class Node2{
    Node2 a[];
    int ew;
    int count;

    public Node2(){
        this.a = new Node2[26];
        this.ew = 0;
        this.count = 0;

    }

    boolean containskey(char c){
        return a[c-'a']!=null;
    }

    Node2 get(char c){
        return a[c-'a'];
    
    }

    void put(char c,Node2 nextnode){
        a[c-'a'] = nextnode;
    }

    int isEnd(){
        return ew;
    }

    int getCount(){
        return count;
    }

}


public class trie_2 {
    private Node2 root;

    public trie_2(){
        root = new Node2();
    }

    public void insert(String word){ // tc -> O(n) where n is length of word
        Node2 node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!node.containskey(c)){
                node.put(c,new Node2()); // adding new node reference
            }
            node = node.get(c); // moving to next node
            node.count++;
        }
        node.ew++; // marking end of word
    }

    // countWordsEqualTo
    public int countWordsEqualTo(String word) {
        Node2 node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!node.containskey(c)){
                return 0;
            }
            node = node.get(c);
        }
        return node.ew;
    }

    // countWordsStartingWith
    public int countWordsStartingWith(String prefix) {
        Node2 node = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(!node.containskey(c)){
                return 0;
            }
            node = node.get(c);
        }
        return node.count;
    }

    // erase
    public void erase(String word){
        Node2 node = root;
        for(int i = 0;i<word.length(); i++){
            char c = word.charAt(i);
            if(!node.containskey(c)){
                // throw error no word exist
                throw new IllegalArgumentException( word +" Word does not exist in the trie.");
            }
            node = node.get(c);
            node.count = Math.max(node.count-1,0);

        }
        if(node.ew>0) node.ew = Math.max(node.ew-1,0);
        else{
            // throw error no word exist
            throw new IllegalArgumentException(word +" Word does not exist in the trie.");
        }
    }

    public static void main(String[] args) {
        trie_2 t = new trie_2();
        t.insert("apple");
        System.out.println(t.countWordsEqualTo("apple")); // 1
        System.out.println(t.countWordsStartingWith("app")); // 1
        t.insert("app");
        System.out.println(t.countWordsEqualTo("app")); // 1
        System.out.println(t.countWordsStartingWith("app")); // 2
        t.erase("app");
        System.out.println(t.countWordsEqualTo("app")); // 0
        System.out.println(t.countWordsStartingWith("app")); // 1
        t.erase("app");
    }

}
