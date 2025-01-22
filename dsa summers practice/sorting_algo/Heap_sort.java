import java.util.Scanner;

public class Heap_sort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Heap_sort heap_sort = new Heap_sort(6);

        for (int i = 0; i < 6; i++) {
            heap_sort.insert(input.nextInt());
            
        }

        heap_sort.print();

    }

    int n;
    Integer arr_heap[];

   public  int size(){
       return n;

   }

   public Heap_sort(int size){
        arr_heap = new Integer[size+1];   
        n = 0;
   }

   boolean isEmpty(){
       if(n ==0){
           return true;
       }
       return false;
   }

   void insert(int key){
        if(isEmpty()){
            //base case
            n = n+1;
            arr_heap[n] = key;
        }
        else
        {
            n++;
            arr_heap[n] = key;
            swip(n);
            
        }
   }

    void swip(int i){

        int parent = i/2;
        while(i> 1 && arr_heap[parent]<arr_heap[i]){
            
            int temp = arr_heap[parent];
            arr_heap[parent] = arr_heap[i];
            arr_heap[i] = temp;
            i = i/2;
        }

   }

   void print(){
    for (int i = 1; i <=n; i++) {
        System.out.print(arr_heap[i] + " ");
    }
    
}
}
