
import java.util.ArrayList;

public class Tree {
    TreeNode root;

    Tree(){
        root = null; 
    }

    public static class TreeNode{
        TreeNode left, right;
        int data;

        public TreeNode(int data){
            this.data = data;
            this.left = this.right= null;
        }
    }


    public void insert(int data){
        root = insert_bs(root, data);
    }

    public TreeNode insert_bs(TreeNode root , int data){
        if(root == null){
            root = new TreeNode(data);
            return root;
        }
        if(data < root.data){
            root.left = insert_bs(root.left , data);
        }else{
            root.right = insert_bs(root.right , data);
        }
        return root;
    }

    ArrayList<Integer> steps;
    int count = -1;
    boolean FindPath(TreeNode node ,int data){
        
        if(node == null){
            return false;
        }

        if(node.data == data){
            count++;
            steps.add(node.data);
            return true;
        }
        boolean status_left = FindPath(node.left, data);
        if(status_left== true){
            count++;
            steps.add(node.data);
            return true;
        }

        boolean status_right = FindPath(node.right, data);
        if(status_right== true){
            count++;
            steps.add(node.data);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Tree q = new Tree();
        q.steps = new ArrayList<>();
        q.insert(8);
        q.insert(3);
        q.insert(10);
        q.insert(1);
        q.insert(6);
        q.insert(14);
        q.insert(4);
        q.insert(7);
        q.insert(13);
        // q.printLvlOrder();
        int a = 1, b = 7;
        q.FindPath(q.root, a);
        System.out.println("1:-Distance between root to a is "+q.count);
        ArrayList<Integer> path_1 = new ArrayList<>(q.steps);
        q.steps.clear();
        q.count = -1;
        q.FindPath(q.root, b);
        ArrayList<Integer> path_2 = new ArrayList<>(q.steps);
        System.out.println("1:-Distance between root to a is "+q.count);
        
        int i = path_1.size() -1 ;
        int j = path_2.size() - 1 ;
        while(i >=0 && j>=0 && path_1.get(i) == path_2.get(j)){
            i--;
            j--;
        }
        j++;    
        i++;
        System.out.println("Distance between a and b = " + (i+j));

    }

    public void printLvlOrder(){
        int h = height(root);
        int lvl = 1;
        while(lvl <= h){
            Printlvlorder(root, lvl);
            lvl++;

        }
    }
    public void Printlvlorder(TreeNode root , int lvl ){
        if(root == null)
            return;
        if(lvl == 1){
            System.out.print(root.data + " ");
        }
        else if( lvl>1){
            Printlvlorder(root.left, lvl-1);
            Printlvlorder(root.right, lvl-1);
        }
    }
    public int height(TreeNode root){
        if(root == null)
            return 0 ;
        else{
            int leftheight = height(root.left);
            int rightheight = height(root.right);
            return leftheight > rightheight ? leftheight+1 : rightheight+1;
        }
    }
}