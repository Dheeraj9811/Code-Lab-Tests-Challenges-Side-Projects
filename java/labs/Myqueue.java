import java.util.Scanner;

public class Myqueue {
    Listnode front ;  // insent variable this all
    Listnode rear;
    int count ;

    public void Toadd(int data){// to add data in queue
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

    public void Todlt(){
        if(isempty()){
            System.out.println("EMPTY");
            return;
        }
        int temp = front.data;
        //System.out.println("poping out this no = " + temp);
        front = front.next;
        count--;

    }
    public void peek(){
        if(isempty()){
            System.out.println("EMPTY");
            return;
        }
        System.out.println(front.data);

    }

    boolean isempty(){
        return count == 0 ;
    }

    static class Listnode{
        int data;
        Listnode next;

        public Listnode(int data){
            this.data = data;
            next = null;
        }
    }

    public  Myqueue(){
        this .front= null;
        this.rear = null;
        count = 0;
    }

    public static void main(String[] args) {
        Myqueue q = new Myqueue();
        Scanner input = new Scanner(System.in);
        int n ,y, x ;
        n = input.nextInt();
        while(n>0){
            y = input.nextInt();
            if(y == 1){
                q.Toadd(input.nextInt());
                n--;
            }else if(y == 2){
                q.Todlt();
                n--;
            }else if(y == 3){
                q.peek();
                n--;
            }
        } 
        
    }


}
