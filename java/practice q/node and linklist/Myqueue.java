
public class Myqueue {
    Listnode front ;  // insent variable this all
    Listnode rear;
    int count ;


    boolean isempty(){
        return count == 0 ;
    }
    public void enqueue(int data){// to add data in queue
        Listnode toadd = new Listnode(data);
        if(isempty()){
            front = rear = toadd;
            
        }else{
            rear.next = toadd;
        }
        rear = toadd;
        rear.next = null;
        count++ ;
    }

    public void dequeue(){
        if(isempty()){
            System.out.println("already empty");
            return;
        }
        int temp = front.data;
        System.out.println("poping out this no = " + temp);
        front = front.next;
        count--;
        

    }


    public void peek(){
        if(isempty()){
            return;
        }
        System.out.println(front.data);

    }
    public void print(){
        if (isempty()){
            System.out.println("queue is empty");
            return;
        }
        Listnode current = front;
        while(current.next !=null){
            System.out.println(current.data);
            current = current.next;
        }System.out.println(current.data);
    }

    public  Myqueue(){
        this .front= null;
        this.rear = null;
        count = 0;
    }
    
    static class Listnode{
        int data;
        Listnode next;

        public Listnode(int data){
            this.data = data;
            next = null;
        }
    }
    public static void main(String[] args) {
        Myqueue Q = new Myqueue();
        Q.enqueue(25);
       Q.enqueue(12);
        Q.enqueue(10);
    //    Q.dequeue(); 
    //    Q.print();
    //    Q.dequeue(); 
    //    Q.print();  
        Q.peek();

    }

}
