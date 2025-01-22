public class Q2 {
	static class Node {
		char data;
		Node next;

		// constructor of Node class:
		Node(char d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		char[] arr = {'a', 'b', 'e', 'c', 'd'};
		int n = arr.length;
		int k = 1;

		My_stack s = new My_stack();
		Node head = null;
		s.push(arr[0]);
		int count = 0;
		
		for(int i = 1; i < n; i++) {
			if((s.top() > arr[i]) && count < k) {
				s.pop();
				head = s.push(arr[i]);
				count++;
			}
			else if (i >= n - k && count < k) {
					count++;
			}
			else {
				head = s.push(arr[i]);
			}
		}
		head = reverse(head);
		printLL(head); //In the order of furthest to closest to dumbeldore
		 			   // Since we are dealing with stack its LIFO
	}

	public static void printLL(Node head){
		while(head != null){
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	static class My_stack{
		//Node class from LL file
		Node head;
		int size;
		My_stack() {
			head = null;
			size = 0;
		}

		Node push(char x) {
			Node nn = new Node(x);
			nn.next = head;
			head = nn;
			size++;
			return head;
		}

		int pop(){
			if(size==0) {return -1;}
			else {
				int x = head.data;
				head = head.next;
				size--;
				return x;
			}
		}

		int top(){
			if(size==0) {return -1;}
			else {return head.data;}
		}

		boolean isEmpty(){
			return size == 0;
		}
	}

	public static Node reverse(Node node)
	{
		Node prev = null;
		Node curr = node;
		Node succ;

		while (curr != null) {
			succ = curr.next;
			curr.next = prev;
			prev = curr;
			curr = succ;
		}
		return prev;
	}
}

//Time complexity:
//Suppose there are n total guests. (arr.length=n)
//Time complexity of iterating over the array: O(n)
//Total number of push/pop operations that can be done: O(n)
//(You cannot make more than n people disappear, sit at their positions)
//Therefore, total time complexity: O(n)
//
//Space complexity: O(n) (stack has to be as large as the number of guests)