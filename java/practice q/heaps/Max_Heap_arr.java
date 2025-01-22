import java.util.Scanner;


public class Max_Heap_arr {
    

    Integer[] heap;
    int n;
    public Max_Heap_arr(int size){
        heap = new Integer[size + 1 ];   // index 0 is empty
        n = 0;
    }

    public boolean isEmpty(){
        return (n == 0) ;    // if n == 0 return true
    }
    public int size(){
        return n;
    }
    public void insert(int key ){
        if(isEmpty()){
            n++;
            heap[n] = key;   
        }
        else{
            n++;
            heap[n] = key;
            swip(n);

        }
        
    }
    void swip(int k ){  // swping Downtoup 
        while(k > 1 && heap[k/2] < heap[k]){   //k/2 give parent location 
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2;
        }
    }
    
    void swipDlt(int size){ // swiping up to down  
        int i = 1; int temp; int k;
        while(i<size && heap[i]<heap[2*1]){
            k = (heap[2*i] > heap[2*i+1]) ? 2*1   : 2*i+1 ;
            temp = heap[k];
            heap[k] = heap[i];
            heap[i] = temp;
            i = 2*i;

        }
        
        
    }

    void dlt(){
        if(isEmpty()){
            return;
        }
        else if(n == 1) {
            heap[n] = null;
            
        }
        else{
            int temp = heap[1];
            heap[1] = heap[n];
            heap[n] = null;
            n = n-1;
            swipDlt(n);
            System.out.println(temp);
             
        }   
    }
    
    void print(){
        for (int i = 1; i <=n; i++) {
            System.out.print(heap[i] + " ");
            
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        Max_Heap_arr heap = new Max_Heap_arr(n);
        for (int i = 0; i < n; i++) {
            heap.insert(input.nextInt());
            
        }
        input.close();
        heap.print();
        System.out.println(heap.size());
        heap.dlt();
        heap.print();
    }

}

class Min_Heap_arr{
    Integer[] heap;
    int n;

    public Min_Heap_arr(int size){
        heap = new Integer[size + 1 ];   // index 0 is empty
        n = 0;
    }

    public boolean isEmpty(){
        return (n == 0) ;    // if n == 0 return true
    }
    public int size(){
        return n;
    }
    public void insert(int key ){
        if(isEmpty()){
            n++;
            heap[n] = key;   
        }
        else{
            n++;
            heap[n] = key;
            swip(n);

        }
        
    }
    void swip(int k){
        while(k>1 && heap[k] < heap[k/2]){
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp ; 
            k = k/2;
        }
    }
    void print(){
        for (int i = 1; i <=n; i++) {
            System.out.print(heap[i] + " ");
        }
        
    }
  
}