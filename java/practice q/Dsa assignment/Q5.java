public class Q5 {
    public static void main(String[] args) {
        MyLinkList list = new MyLinkList();

        list.add(1);  
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        list.print();
        list.reorder();
        System.out.println();
        list.print();
        
        
    }
}
class MyLinkList {
    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) { // constructor
            this.data = data;
            next = null;
        }
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
    void print(){
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    Node reverse(Node node ){
        Node prev = null;
        Node current = node;
        while( current != null){
            Node temp = current.next;
            current.next = prev;
            // from here move every pointer to new location 
            prev = current;
            current = temp;
        }
        node = prev;
        return node;


    }

    void reorder(){
        Node middle = head , temp = middle.next;
        while(temp !=null && temp.next != null){
            middle = middle.next;
            temp = temp.next.next;
        }

        // spliting from middle 
        Node list1 = head;
        Node list2 = middle.next;
        middle.next = null;

        list2 = reverse(list2);
        MyLinkList.Node node = new Node(-1);
        Node current = node;
        while(list1 != null || list2 != null){

            if(list1 != null){
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            }
            if(list2 != null){
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }
        node = node.next;
        head = node;
    }
    
}