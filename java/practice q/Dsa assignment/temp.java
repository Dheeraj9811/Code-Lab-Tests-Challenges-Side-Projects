// class LinkedList { 
//     public static void main(String[] args) {
        
//     }
  
//     static Node head;  // head of the list 
  
  
//     /* Node Class */
//     static class Node { 
  
//         char data; 
//         Node next; 
  
//         // Constructor to create a new node 
//         Node(char d) { 
//             data = d; 
//             next = null; 
//         } 
//     } 
  
//     void printlist(Node node) { 
//         if (node == null) { 
//             return; 
//         } 
//         System.out.print("| ");
//         while (node != null) { 
//             System.out.print(node.data); 
//             if (node.next != null)
//             {
//                 System.out.print(" | --> | ");
//             }
//             node = node.next; 
//         } 
//         System.out.print(" |");
//     } 
  
//     Node reverselist(Node node) { 
//         Node prev = null, curr = node, next; 
//         while (curr != null) { 
//             next = curr.next; 
//             curr.next = prev; 
//             prev = curr; 
//             curr = next; 
//         } 
//         node = prev; 
//         return node; 
//     } 

//      void reorder(Node node) { 
  
//         //Finding the middle point 
//         Node p1 = node, p2 = p1.next; 
//         while (p2 != null && p2.next != null) { 
//             p1 = p1.next; 
//             p2 = p2.next.next; 
//         } 
  
//         //Spliting the linked list 
        
//         Node node1 = node; 
//         Node node2 = p1.next; 
//         p1.next = null; 
  
//         //Reverse the second half
//         node2 = reverselist(node2); 
  
//         // 4) Merge alternate nodes 
//         node = new Node('X'); 
//         Node curr = node; 
//         while (node1 != null || node2 != null) {   
            
//             if (node1 != null) { 
//                 curr.next = node1; 
//                 curr = curr.next; 
//                 node1 = node1.next; 
//             } 

//             if (node2 != null) { 
//                 curr.next = node2; 
//                 curr = curr.next; 
//                 node2 = node2.next; 
//             } 
//         } 
//         node = node.next; 
//     } 

//     public static void main(String[] args) { 
  
//         LinkedList list = new LinkedList(); 
//         list.head = new Node('A'); 
//         list.head.next = new Node('B'); 
//         list.head.next.next = new Node('C'); 
//         list.head.next.next.next = new Node('D'); 
//         list.head.next.next.next.next = new Node('E'); 
//         list.head.next.next.next.next.next = new Node('F'); 
//         list.head.next.next.next.next.next.next = new Node('G'); 
//         list.reorder(head);
//     }
// }
