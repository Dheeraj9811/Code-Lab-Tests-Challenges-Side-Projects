import java.util.LinkedList;
import java.util.Queue;

/**
 * BST
 */
public class BST {

    Node root;

    BST(){
        root = null;
    }
    

    public void insert(int data){
        this.root =insert(root, data);
    }
    
    // insert fn which return root 
    Node insert(Node root , int key){
        if(root == null) {
            root = new Node(key);
            return root;
        }
        else if(root.data> key){
            root.left = insert(root.left, key);
        }else{
            root.right = insert(root.right, key);
        }
        System.out.println("hello");
        return root;

    }
    int max(Node root){
        if(root.right != null){
            return max(root.right);
        }else{
            return root.data;
        }
    }
    void dlt(int key){
        this.root = dlt(root,key );
    }
    // dlted node 
    Node dlt(Node root , int key){
        if(root == null) return null;
        
        if(key > root.data){
            root.right = dlt(root.right, key);
        }
        else if(key < root.data){
            root.left = dlt(root.left, key);
        }
        else if( key == root.data){

            if(root.right!= null && root.left != null){
                int lmax = max(root.left);
                root.data = lmax;
                root.left = dlt(root.left, lmax);
                return root;

            }else if(root.left !=null){
                return root.left;
            }
            else if(root.right != null){
                return root.right;

            }
            else{
                return null;
            }

        }
        return root;
    }

    void printlvlorder(){
        if(root != null){
            Queue<Node> q = new LinkedList<>();
            Node temp = root;
            int count_lvl = 0;
            q.add(temp);
            while(!q.isEmpty()){
                System.out.println();
                System.out.println(count_lvl+ "Level");
                int size = q.size();
                for(int i = 0 ; i<size ; i++){
                    temp = q.poll();
                    System.out.print(temp.data+ "->");
                    if(temp.left != null) q.add(temp.left);
                    if(temp.right != null) q.add(temp.right);
                    
                }
                
                count_lvl++;
            }
        }
    }
    
    void InOrder(){
        printInOrder(root);
    }

    void printInOrder(Node root ){
        if(root == null){
            return;
        }
        else{
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }

    void PreOrder(){
        printPreOrder(root);
    }

    void printPreOrder(Node root){
        if(root == null){
            return;
        }
        else{
            System.out.print(root.data + " ");
            printInOrder(root.left);
            printInOrder(root.right);
        }
    }



    public static void main(String[] args) {
        BST head = new BST();
        head.insert(5);
        head.insert(1);
        head.insert(4);
        head.insert(3);
        head.insert(6);
        // head.insert(6);
        // head.insert(30);
        // head.insert(28);
        // head.insert(31);
        // head.insert(25);
        // head.insert(29);
        head.printlvlorder();
        
        // System.out.println();
        // head.dlt(30);
        
        // head.printlvlorder();
        System.out.println();
        System.out.println("InOrder");
        head.InOrder();
    }

    class Node{

        Node left ;
        Node right;
        int data;
    
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        
    }
}
