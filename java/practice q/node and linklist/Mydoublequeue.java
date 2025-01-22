public class Mydoublequeue<E> {
    Dounode<E> front , rear;
    int count ;

    public void AddToHead(E data){
        Dounode<E> toAdd = new Dounode<E>(data);
        if(isempty()){
            front = rear = toAdd;
            count ++;
            return;
        }toAdd.next = front;
        front.prev = toAdd;
        front = toAdd;
        count ++;
        
    }

    public void print(){
        if (isempty()){
            System.out.println("queue is empty");
            return;
        }
        Dounode<E> current = front;
        while(current.next !=null){
            System.out.println(current.data);
            current = current.next;
        }System.out.println(current.data);
    }

    boolean isempty(){
        return count == 0 ;
    }

    static public class Dounode<E>{
        E data;
        Dounode<E> prev ;
        Dounode<E> next;

        public Dounode(E data){
            this.data = data;
            this.next = null;
            this.prev = null;
            

        }
    }
    
    public  Mydoublequeue(){
        this .front= null;
        this.rear = null;
        count = 0;
    }
    public static void main(String[] args) {
        Mydoublequeue<Integer> q = new Mydoublequeue<>();
        q.AddToHead(21);
        q.AddToHead(16);
        q.print();
    }

}
