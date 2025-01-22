public class MyDoublyLinkList { // using temp to move in list 
    _node head ,tail = null;

    public void add(int data){
        _node ToAdd = new _node(data);
        
        if (head == null){
            head = tail = ToAdd;
            head.prev = null;
            tail.next = null;
        }
        else{
            tail.next = ToAdd;  // joinning too add to last;
            ToAdd.prev= tail;   // joinning to add to previous node ;
            tail =ToAdd;        // shifting tial to again to last node ;
            tail.next = null;   // making tail nest = null;
        }
    }
    
    void dlt_end(){
        _node temp ;
        
        if(head == null){
            System.out.println("list isempty");
            return;
        }
        else{

            if(head!= tail){
                tail = tail.prev;
                tail.next = null;
            }
            else{
                head = tail=null;
            }
        }

    }

    public void print(){
        _node current = head;    // 
        if( head == null){
            System.out.println("kist is empty");
            return;
        }
        while(current != null){
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
    
    public void addAtHead(int data){
        _node toAdd = new _node(data);
        if(head!= null){
            toAdd.next= head;
            toAdd.prev=null;
            head.prev = toAdd;
            head = toAdd;
        }
        else{
            add(data);
        }
    }

    static  class _node{
        int data;
        _node prev ;
        _node next;

        public _node(int data){
            this.data = data;
            
            
        }
    }
    public static void main(String[] args) {
        MyDoublyLinkList list = new MyDoublyLinkList();
        list.add(2);
        list.add(5);
        list.addAtHead(7);
        list.dlt_end();
        list.print();
        
    }
}
