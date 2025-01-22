public class Avl {
    public int balanceNumber(Node n) {
		if (n != null) {
			return (giveHeight(n.left) - giveHeight(n.right));
		}
		return 0;
	}

	public int giveHeight(Node n) {
		if (n != null) {
			return n.height;
		}
		return 0;
	}

	public Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		// Rotatio is done here
		x.right = y;
		y.left = T2;

		// here we are updating  heights of tree after right roatation
		x.height = Math.max(giveHeight(x.left), giveHeight(x.right)) + 1;
		y.height = Math.max(giveHeight(y.left), giveHeight(y.right)) + 1;

		return x;
	}

	public Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		// Rotatio is doen here
		y.left = x;
		x.right = T2;

		// here we are updating  heights of tree after left roatation
		x.height = Math.max(giveHeight(x.left), giveHeight(x.right)) + 1;
		y.height = Math.max(giveHeight(y.left), giveHeight(y.right)) + 1;

		return y;
	}

	public Node insert(Node node, int data) {
		if (node == null) {
			return (new Node(data));
		}
		if (node.data > data) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}
		// new height udate 
		node.height = Math.max(giveHeight(node.left), giveHeight(node.right)) + 1;

		int balDiff = balanceNumber(node);

		// Left Rotate
		if (balDiff > 1 && data < node.left.data) {
			return rightRotate(node);
		}

		// Right Rotate
		if (balDiff < -1 && data > node.right.data) {
			return leftRotate(node);
		}

		// Left Right Rotate
		if (balDiff > 1 && data > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Rotate
		if (balDiff < -1 && data < node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(" " + root.data);
			inorder(root.right);
		}
	}
	public Node dlt(Node root ,int data){
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
                Node temp = (root.left ==null) ? root.right : root.left;
            
                if(temp == null){
                    return null;
                }else{
                    return temp;
                }
            }else{
                Node successor = findScuccessor(root);
                root.data = successor.data;
                root.right = dlt(root.right, successor.data);
                return root;
            }       
        }
        return root;
    }
    public Node findScuccessor(Node root){
        if(root == null) {
            return null;
          }
          
          Node temp = root.right;
          
          while(temp.left != null) {
            temp = temp.left;
          }
          
        return temp;
    }
    
	public static void main(String args[]) {
		Node root = null;
		Avl i = new Avl  ();
		root = i.insert(root, 4);
		root = i.insert(root, 2);
		root = i.insert(root, 1);
		root = i.insert(root, 5);
		root = i.insert(root, 6);
		root = i.insert(root, 9);
		root = i.insert(root, 14);
		root = i.insert(root, 11);
		root = i.insert(root, 10);
		root = i.insert(root, 20);
		root = i.dlt(root, 14);
		System.out.print("Inorder Traversal of Constructed AVL Tree :");
		i.inorder(root);
		System.out.print("\n New Root of AVL Tree is : " + root.data);
	}
}

class Node {
	int data;
	Node left;
	Node right;
	int height;

	public Node(int data) {
		this.data = data;
		height = 1;
	}

    
}
