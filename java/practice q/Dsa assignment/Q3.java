public class Q3 {
    class Node
{
   int key, height;
   Node left, right;
   Node(int d)
   {
       key = d;
       height = 1;
   }
}

//main driver class
public class barber
{
   Node root; //defining node each time
 
   static int n = 0; // n counts number of nodes 

   static int count = 0;

   int height(Node N) // to find height of tree
   {
       if (N == null)
           return 0;

       return N.height; 
   }

   int max_val(int a, int b) // max value function to fun which is greater
   {
       return (a > b) ? a : b;
   }

   Node right_rotate(Node y)
   {
       Node x = y.left;
       Node T2 = x.right;
       x.right = y;
       y.left = T2;
       y.height = max_val(height(y.left), height(y.right)) + 1;
       x.height = max_val(height(x.left), height(x.right)) + 1;
       return x;
   }

   Node left_rotate(Node x)
   {
       Node y = x.right;
       Node T2 = y.left;
       y.left = x;
       x.right = T2;
       x.height = max_val(height(x.left), height(x.right)) + 1;
       y.height = max_val(height(y.left), height(y.right)) + 1;
       return y;
   }


   int get_balance(Node N)
   {
       if (N == null)
           return 0;
       return height(N.left) - height(N.right);
   }

   Node insert(Node node, int key)
   {
       n=n+1;//to increase no of nodes value
       if (node == null)
           return (new Node(key));
       if (key < node.key)
           node.left = insert(node.left, key);
       else if (key > node.key)
           node.right = insert(node.right, key);
       else
           return node;
       node.height = 1 + max_val(height(node.left),
               height(node.right));
       int balance = get_balance(node);
       if (balance > 1 && key < node.left.key)
           return right_rotate(node);
       if (balance < -1 && key > node.right.key)
           return left_rotate(node);
       if (balance > 1 && key > node.left.key) {
           node.left = left_rotate(node.left);
           return right_rotate(node);
       }
       if (balance < -1 && key < node.right.key) {
           node.right = right_rotate(node.right);
           return left_rotate(node);
       }
       return node;
   }

   Node min_value_node(Node node)
   {
       Node current = node;
       while (current.left != null)
           current = current.left;

       return current;
   }

   static int minValue(Node node)
   {
       Node current = node;
       while (current.left != null)
       {
           current = current.left;
       }
       return (current.key);
   }


   static int maxValue(Node node)
   {
       if (node == null)
           return Integer.MIN_VALUE;
       int res = node.key;
       int l_res = maxValue(node.left);
       int rres = maxValue(node.right);
       if (l_res > res)
           res = l_res;
       if (rres > res)
           res = rres;
       return res;
   }

   Node delete(Node root, int key)
   {
       n=n-1;//to decrease no of nodes value
       if (root == null)
           return root;
       if (key < root.key)
           root.left = delete(root.left, key);
       else if (key > root.key)
           root.right = delete(root.right, key);
       else
       {
           if ((root.left == null) || (root.right == null))
           {
               Node t = null;
               if (t == root.left)
                   t = root.right;
               else
                   t = root.left;
               if (t == null)
               {
                   t = root;
                   root = null;
               }
               else
                   root = t;
           }
           else
           {
               Node t = min_value_node(root.right);
               root.key = t.key;
               root.right = delete(root.right, t.key);
           }
       }

       if (root == null)
           return root;
       root.height = max_val(height(root.left), height(root.right)) + 1;
       int balance = get_balance(root);
       if (balance > 1 && get_balance(root.left) >= 0)
           return right_rotate(root);
       if (balance > 1 && get_balance(root.left) < 0)
       {
           root.left = left_rotate(root.left);
           return right_rotate(root);
       }
       if (balance < -1 && get_balance(root.right) <= 0)
           return left_rotate(root);
       if (balance < -1 && get_balance(root.right) > 0)
       {
           root.right = right_rotate(root.right);
           return left_rotate(root);
       }
       return root;
   }

   public static Node kthSmallest(Node root, int k)
   {
       if (root == null)
           return null;
       Node left = kthSmallest(root.left, k);
       if (left != null)
           return left;
       count++;
       if (count == k)
           return root;
       return kthSmallest(root.right, k);
   }

   public static int printKthSmallest(Node root, int k)
   {
       count = 0;
       Node res = kthSmallest(root, k);
       if (res == null)
       {
           //There are less than k nodes in the AVL tree}
       }
       return res.key;
   }

   static Scanner sc= new Scanner(System.in);
   static barber tree = new barber();

   public static int Alpha_query()
   {
       //barber can type 0 for min and 1 for max
       int a= sc.nextInt();
       int del_value;
       if(a==0)
           del_value = tree.minValue(tree.root);
       else
           del_value = tree.maxValue(tree.root);
       tree.root = tree.delete(tree.root, del_value);
       return del_value;
   }

   public static int Beta_query()
   {

       //barber can type k for the val he requires
       int k= sc.nextInt();
       int del_value;
       del_value = tree.printKthSmallest(tree.root,k);
       tree.root = tree.delete(tree.root, del_value);
       return del_value;
  
   }
  
   public static int Gamma_query(int n)
   {
       //n can be calculated . We can n=n+1 when we insert a node and n=n-1 when we delete a node in main
       
       //this way we always have total no of nodes with us
       int k=(n-1)/2 ;
       int del_value;
       del_value = tree.printKthSmallest(tree.root,k);
       tree.root = tree.delete(tree.root, del_value);
       return del_value;// Value which has been deleted
   }

   public static void main(String[] args) {
        AvlTree q = new Tree();
        customer_count = q.n

   }
   {
       //we simply do n=n+1 when we insert a node and n=n-1 when we delete a node in main

       //These line contain explanation of how above mad functions will be used

       //Constructing tree using
       //tree.root = tree.insert(tree.root, value)
       //Value will be the ID of each person

       //Delete tree nodes using
       //tree.root = tree.delete(tree.root, value)
       //Value will be the ID of each person who has been dealt with
       //dealt with here means ,person's hair is cut after being chosen


       // ALPHA(will choose b/w min and max with prob 0.5 each)

       //WE CAN USE Alpha_query TO FIND ID WE NEED TO REMOVE
       //logic of this query function is given below
       //Finding min value through this function and storing in del_value
       //int del_value = tree.minValue(tree.root)
       //or
       //Finding max value through this function and storing in del_value
       //int del_value = tree.maxValue(tree.root)
       //then
       //delete the min or max value as person's hair is cut
       //tree.root = tree.delete(tree.root, del_value)

       //BETA(will choose k th smallest ID no. where k is randomly chosen from 1 to no. of people)

       //WE CAN USE Beta_query TO FIND ID WE NEED TO REMOVE
       //logic of this query function is given below
       //finding kth smallest element in tree with this function
       //int del_value = tree.printKthSmallest(tree.root,k_value)
       //k_value is decided by the beta
       //then
       //delete the kth id as person's hair is cut
       //tree.root = tree.delete(tree.root, del_value);

       //GAMMA(will choose median id always)

       //WE CAN USE Gamma_query TO FIND ID WE NEED TO REMOVE (we take argument as total no. of nodes)
       //logic of this query function is given below
       //Gamma_query will have argument n which is global variable and keeps tab of number of nodes
       //we can achieve this by giving k th right value
       //int k = (n+1)/2 th ID where n number of nodes in tree
       //we can easily make a n which increments by 1 on on node addition and decremented by 1 on node deletion	
       //here n is globally defined and increments in insert and decrements in delete
       //int del_value = tree.printKthSmallest(tree.root,k_value)
       //k_value is k
       //then
       //delete the kth id as person's hair is cut (here k acts as median)
       //tree.root = tree.delete(tree.root, del_value);

       //SO CONSIDERING WE HAVE A LIST OF ID’s ,WE WILL APPLY THE 3 QUERIES SEQUENTIALLY 
       //AND KEEP DELETING THE NODES 
       //UNTIL 0 NODES  ARE LEFT
   }
}
_____________________________

// In driver func we can have a menu based option where there is option to insert id and also  selecting query by either alpha,beta or gamma (we can handle exceptions like if no id’s are left ,then no query is taken)

// Time complexity of various func used

// Insert:O(log2n)
// Delete:O(log2n)
// minValue:O(n)
// maxValue:O(n)
// printKthSmallest:O(h) where h is the height of the tree → O(log2n)

// As queries by barber are using 1 of the above functions so their time complexity will be the same as of the func being used
// Alpha_query uses min and max functions
// Beta_query uses smallest kth element function
// Gamma_query also uses smallest kth element function
    
}
