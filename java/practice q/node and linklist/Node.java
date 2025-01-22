import java.util.Scanner;





public class Node {

    public static void main(String[] args) {
        int q ,a,b ;
        Scanner input = new Scanner(System.in);
        q = input.nextInt();
        Node ls = new Node();

        
    for (int i = 0; i < q; i++) {
      int qu = input.nextInt();
      if (qu == 1) {
         a = input.nextInt();
        ls.insert(a);
      }
      if (qu == 3) {
        ls.show();
      }
      if (qu == 2) {
          a = input.nextInt();
        ls.Dlt(a);
      }
      if (qu == 4) {
          a =input.nextInt();
          b= input.nextInt();
          ls.insert_at(a, b);
      }
    }
    }
    


    int data;
    Node next;
    Node head;  


    public void insert(int data){
        Node node = new Node();    // creating new node 
        node.data = data;
        node.next = null;

        if (head==null){// if head == null means its a first node

            head = node;
        }else{
            Node n = head; // Node n :used here to travell and hold tem data
            while (n.next!= null) {
                n = n.next;
            }
            n.next =node;    
        }
        
    }
    public void insert_at_start(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.next = head;
        head = node;
    }
    public void insert_at(int index, int data){
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(index==0){
            insert_at_start(data);
        }
        else{
        Node n = head;
        for (int i = 0; i < index-1; i++) {
            n = n.next;     
        }node.next = n.next;
        n.next = node;
        }
         
        
    }
    public void Dlt(int index){
        if (index == 0){
            head = head.next;
        }else{
            Node n = head;
            Node temp =null;
            for (int i = 0; i < index-1; i++) {
                n = n.next;     
            }
            temp = n.next;
            n.next = temp.next;
            temp = null;    // here system will dlt this by taking in garbage isliye 
        }
    }

    public void show(){
        Node node = head;
        while (node.next!=null) {
            System.out.println(node.data);
            node = node.next;
        }System.out.println(node.data);

    }   
}
