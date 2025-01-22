
public class MyLinkList {
    Node head;

    void insertAtHead(int data){
        Node toAdd = new Node(data);
        if(head == null) {
            head = toAdd;
            return;
        }
        toAdd.next = head;
        head = toAdd;
    }

    void insertAtPoss(int data , int n){
        Node toAdd = new Node(data);
        if(n == 0 ){
            head = toAdd;
            return;
        }
        Node temp = head;
        for (int i = 0; i < n-1; i++) {
            temp = temp.next;
        }
        toAdd.next = temp.next;
        temp.next = toAdd;


    }
    
    void add (int data){
        Node toAdd = new Node(data);  // createing new node to save data

        if(head == null) {
            head = toAdd;
            return;
        }
        Node temp = head;           // taking head  data into temp  
        while(temp.next != null){           // temp is used here to travell inside list
            temp = temp.next;
        }
        temp.next = toAdd;
    }

    void dltAtBegin(){
        
        if(head == null){
            System.out.println("list is empty");
        }else if( head.next == null ){
            head = null;
        }else{
            Node temp = head ;
            head = temp.next;
            
        }
        
    }

    void dltAtindex(int n ){
        if(n < 1 ){
            return;
        }
        Node temp = head;
        if(n == 1 ){
            
            head = temp.next;
        }else{
            for (int i = 0; temp!=null && i < n-1; i++) {
            temp = temp.next;
            }
            Node next = temp.next.next;    // next to next pr ja kr point kre ga
            temp.next = next;
        
        
        }
    }

    void dltAtLast(){                                        
        if (head == null ){
            System.out.println("list is empty");
        }else if (head.next== null){             /*while(temp.next.next != null) {
                                                    temp = temp.next;
                                                    }
                                                 // change the second last node next pointer to null
                                                    temp.next = null;*/
            head = null;
        }else{
            Node previous = null;
            Node temp = head;
            while(temp.next!= null ){
                previous = temp;
                temp = temp.next;

            }
            previous.next = null;
        }
    }

    void dltWthKey(int n){
        Boolean flag = false;
        Node temp = head ;
        if (head == null){
            return;
        }
        else if(head.next.data == n){
            
            temp = temp.next;
            head = temp;
        }
        

        
        else{
            Node previous = null ;
            
                while(temp.next != null &&temp.data!= n  ){
                
                previous = temp;
                temp = temp.next;
                } 
                if (temp.data == n ){
                    flag = true;
                    previous.next = temp.next; 
                }
            }
        if (flag == false)
            System.out.println("element not found");    
            
            
    }        

    void print(){
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    void recursive_print(Node temp){
        if (temp == null){
            return;
        }else{
            
            System.out.print(temp.data + " ");
             recursive_print(temp.next);
        }
    }

    void  reverse(Node node ){
        Node prev = null;
        Node current = node;
        while( current != null){
            Node temp = current.next;
            current.next = prev;
            // from here move every pointer to new location 
            prev = current;
            current = temp;
        }
        head = prev;


    }
    

    static class Node {
        int data;
        Node next;

        public Node(int data) { // constructor
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        MyLinkList list = new MyLinkList();

        list.add(1);  // rember index start from 0 here put it to 1 
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.print();
        System.out.println();
        list.insertAtPoss(14, 3);
        list.print();
        
        
        //list.dltAtBegin();
        //list.dltAtindex(2);
    //    list.dltAtLast();
       System.out.println();
        list.reverse(list.head);
    //    list.dltWthKey(22); // error if postion of element is head not working prperly fix it 
       list.recursive_print(list.head);
    }// * Deleting a node containing data d        done but error on head case
    // * Deleting a specific element                done 
    // Reversing a Linked List                      iterative done    , recurrsive doubt 
}
