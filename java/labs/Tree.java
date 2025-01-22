import java.util.Scanner;

public class Tree {
    TreeNode root;

    public static class TreeNode{
        TreeNode left, right;
        int data;

        public TreeNode(int data){
            this.data = data;
            this.left = this.right= null;
        }
    }
    Tree(){
        root = null; 
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

    public void insert(int data){
        root = insert_bs(root, data);
    }

    public void printpostOrder(){   // used to call main f(n)
        printpostOrder(root);
    }
    
    public void printpostOrder(TreeNode root ){// left right root
        if (root == null){
            return;
        }
        printpostOrder(root.left);
        printpostOrder(root.right);
        //printpostOrder(root); dlt his line 
        System.out.print(root.data + " ");

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


    public int min(TreeNode root){
        if(root == null) {
            //System.out.println("EMPTY");
            return -1;
          }
          
          while(root.left != null) {
            root = root.left;
          }
          
          return root.data;
    } 


    public int max(TreeNode root){
        if(root == null) {
            //System.out.println("Tree is EMpty");
            return -1;
          }
          
          while(root.right != null) {
            root = root.right;
          }
          
          return root.data;
    }

    public TreeNode dlt(TreeNode root ,int data){
        if(root == null)
            return root;
        
        if(data<root.data){
            root.left = dlt(root.left, data);
        }
        else if(data>root.data){
            root.right = dlt(root.right, data);
        }
        else{
            if(root.left== null || root.right == null){
                TreeNode temp = (root.left ==null) ? root.right : root.left;
            
                if(temp == null){
                    return null;
                }else{
                    return temp;
                }
            }else{
                TreeNode successor = findScuccessor(root);
                root.data = successor.data;
                root.right = dlt(root.right, successor.data);
                return root;
            }       
        }
        return root;
    }
    public TreeNode findScuccessor(TreeNode root){
        if(root == null) {
            return null;
          }
          
          TreeNode temp = root.right;
          
          while(temp.left != null) {
            temp = temp.left;
          }
          
        return temp;
    }
    public void dlt(int data){
        dlt(root, data);
    }
    public void min(){
        int store = min(root);
        if(store == -1 ){
            System.out.println("Empty");
        }else{
            System.out.println(store);
        }
    }
    public void max(){
        int store = max(root);
        if(store == -1 ){
            System.out.println("Empty");
        }else{
            System.out.println(store);
        }
    }
    public static void main(String[] args) {
        Tree q = new Tree();
        /*int n ;
        Scanner input = new Scanner(System.in);
        Scanner intinput = new Scanner(System.in);
        n = intinput.nextInt();
        String enter;
        for (int i = 0; i < n; i++) {
            enter = input.nextLine();
            if(enter == "DELETE"){
                q.dlt(input.nextInt());
            }else if ( enter == "MIN"){
                q.min();
            }else if ( enter == "MAX"){
                q.max();
            }else{
                int data = Integer.parseInt(enter);
                q.insert(data);
            }
            
                        
        }*/
        q.insert(21);
        q.insert(1);
        q.printLvlOrder();
        
        
    }
}
