

public class Tree {
    TreeNode root;
    public static void main(String[] args) {
        Tree q = new Tree();
    //     q.insert(5);
    //     q.insert(1);
    //     q.insert(21);
    //     q.insert(6); 
    //     q.insert(7);
    // //    q.printPreOrder();
    //     q.dlt(5);
    //     System.out.println();
    //     q.printLvlOrder();  // give us sorted array
    // //    System.out.println();
    // //    q.printpostOrder();
    }

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

    public void printPreOrder(){ 
        printPreOrder(root);
    }
    
    public void printPreOrder(TreeNode root){// root then left then right
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
        //System.out.print(root.data+ " ");
    }


    public void printinOrder(){// left root right 
        printinOrder(root);
    }
    
    public void printinOrder(TreeNode root){// left root right
        if(root == null){
            return;
        }
        printinOrder(root.left);
        System.out.print(root.data + " ");
        printinOrder(root.right);
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
