/**
 * my_linklist
 */
public class my_linklist<T> {

    public static void main(String[] args) {
        my_linklist<Integer> list = new my_linklist<>();

        //list.print();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        // list.remove();
        list.addAtpostion(5, 5);
        list.print();
        list.middle(list.head);
        list.remove(5) ;
        list.middle(list.head);
        list.print();
   
        // my_linklist<Integer> reverse = new my_linklist<>();
        // reverse.head =  list.reverse(list.head);

        // reverse.print();
        System.out.println(list.palindrome(list.head));



    }

    // node head pointer
    node<T> head;

    private int length = 0;
    
    my_linklist(){
        this.head = null;
    }

    void add(T data){
        node<T> temp = new node<>(data);
        if(size() == 0){
            head = temp;
            length++;
        }
        else{

            node<T> ptr = head;

            while(ptr.next != null){
                ptr = ptr.next;
            }

            ptr.next = temp;
            length++;
            System.out.println("added sucessfully");
        }

    }

    void addAtpostion(T data , int pos){

        if(pos <1 || pos> size()){

            System.out.println(" error location is either zero or out of index");
        }else if(pos == 1 ){

            node<T> temp = head;
            head =  new node<T>(data);
            head.next = temp;
            System.out.println("added succesfully");
        }else{
            
            node<T> ptr =head;

            while(pos-2> 0){
                ptr = ptr.next;
                pos--;
            }
            node<T> temp = ptr.next;
            ptr.next = new node<T>(data);
            ptr.next.next = temp;


        }

        


    }

    void remove(){
     if( size()> 0){
        node<T> ptr =head;
        int pos = size();

        while(pos-2> 0){
            ptr = ptr.next;
            pos--;
        }
        
        ptr.next = null;
        
     }       
    }

    void remove(int postion){
        if(postion <1 || postion> size()){

            System.out.println(" error location is either zero or out of index");
        }else if(postion == 1 ){

            node<T> temp = head;
            head =  temp.next;
            System.out.println("removed succesfully");
        }else{
            
            node<T> ptr =head;

            while(postion-2> 0){
                ptr = ptr.next;
                postion--;
            }
            node<T> temp = ptr.next;
            ptr.next = temp.next;
        }
    }

    // print list 

    void print(){
        String S = "{";
        node<T> ptr = head;
        if(ptr == null){
            System.out.print(S+"}");

        }
        else{
            while(ptr.next != null){
                S += String.valueOf(ptr.data) + "  ";
                ptr = ptr.next;
            }
            S += String.valueOf(ptr.data) + "  ";
            System.out.println(S + " }");
        }
        
    }
    // fn to return size
    //
    int size(){
        return length;
    }

    //  reverse a link list from givent head

    node<T> reverse(node<T> head){
        node<T> curr = head;
        node<T> prev = null;

        while(curr != null){

            node<T> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        System.out.println("returned new reverse LinkList head");
        return prev;
    }

    // find middle node 

    node<T> middle(node<T> head){
        node<T> slow = head;
        node<T> fast = head;

        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("middle node is " + slow.data);
        return slow;

    }


    //  link list  is palindrome

    boolean palindrome(node<T> head){
        
        if(head == null) return true;

        node<T> mid = middle(head);
        node<T> reverse = reverse(mid);

        node<T> curr = head;
        while(reverse != null){
            if(reverse.data != curr.data) return false;

            reverse = reverse.next;
            curr = curr.next;
        }
        return true;
    }



}

/**
 * node
 */
 class node<T> {
    T data;
    node<T> next;

    node(T data){
        this.data = data;
        this. next = null;

    }


    
}