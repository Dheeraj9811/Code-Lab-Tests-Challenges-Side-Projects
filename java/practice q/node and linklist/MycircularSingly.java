public class MycircularSingly {
    Node head = null;
    Node tail = null;

    public void add(int data){
        Node toAdd = new Node(data);
        if (head != null){
            tail.next = toAdd;
            tail = toAdd;
            tail.next = head;
        }
        else{
            head = toAdd;
            tail = toAdd;
            tail.next = head;
        }
    }

    public void print(){
        Node current = head;
        if (head !=null){
            do {
                System.out.println(current.data+ " ");  
                current = current.next;

            }while(current != head);
        }
        else{
            System.out.println("list is empty");
        }
    }

    static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        MycircularSingly list = new MycircularSingly();
        list.add(21);
        list.add(51);
        list.add(40);
        list.print();
    }
}
