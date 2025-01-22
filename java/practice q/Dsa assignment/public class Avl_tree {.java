public class Avl_tree {
    Tree_node root;
    int count = 0;
    public static void main(String[] args) {
        Avl_tree q = new Avl_tree();
        
        While(count>0){ // count have no. of id inserted inside Avl tree
            
        } 
    }

    

    Avl_tree(){
        root = null;
    }

    public static class Tree_node{
        Tree_node left , right ;
        int data,height;

        public Tree_node( int data ) {
            this.data = data;
            height = 1;
            left = right = null;
        }

    }
    public class AVLtree{
        void updateHeight(Tree_node root ){
          root.height = 1+ Math.max(height(root.left), height(root.right));  
        }
        int height(Tree_node root ){
            return root == null ? -1:root.height;
        }
        int balanceFactor(Tree_node root){
            return (root == null) ? 0 : height(root.right) - height(root.left);
        }
        Tree_node rR(Tree_node temp){  // rotaeing right 
            Tree_node x = temp.left;
            Tree_node y = x.right;
            x.right = temp;
            temp.left = y;
            updateHeight(temp);
            updateHeight(x);
            return x; 
        }

        Tree_node rL(Tree_node temp){
            Tree_node x = temp.right;
            Tree_node y = x.left;
            x.left = temp;
            temp.right = y;
            updateHeight(temp);
            updateHeight(x);
            return x;
        }
        public Tree_node balance(Tree_node y ){
            int check = balanceFactor(y);
            if(check > 1) {
                if(height(y.right.right) > height(y.right.left) ) {
                    y = rL(y);
                }else {
                    y.right = rR(y.right);
                    y = rL(y);
                }
            }else if (check < -1){
                if(height(y.left.left) > height(y.left.right)){
                    y = rR(y);
                }else{
                    y.left = rL(y.left);
                    y = rR(y);
                }
            }
            return y;
        }
    }

    void insert(int data){
        insert(root, data);
        count++
    }
    Tree_node insert(Tree_node root , int data){
        if(root == null){
            root = new Tree_node(data);
            return root;
        }
        if(data < root.data){
                root.left = insert(root.left, data);
            }
        else{
                root.right = insert(root.right, data);
            }
        
        return root;

    }
   
    public Tree_node dlt(Tree_node root ,int data){
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
                Tree_node temp = (root.left ==null) ? root.right : root.left;
            
                if(temp == null){
                    return null;
                }else{
                    return temp;
                }
            }else{
                Tree_node successor = findScuccessor(root);
                root.data = successor.data;
                root.right = dlt(root.right, successor.data);
                return root;
            }       
        }
        return root;
    }
    public Tree_node findScuccessor(Tree_node root){
        if(root == null) {
            return null;
          }
          
          Tree_node temp = root.right;
          
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
    public void Printlvlorder(Tree_node root , int lvl ){
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
    public int height(Tree_node root){
        if(root == null)
            return 0 ;
        else{
            int leftheight = height(root.left);
            int rightheight = height(root.right);
            return leftheight > rightheight ? leftheight+1 : rightheight+1;
        }
    }


}