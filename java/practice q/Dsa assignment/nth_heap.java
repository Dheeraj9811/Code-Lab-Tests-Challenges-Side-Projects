import java.util.Scanner;



public class  nth_heap{
    Integer[] heap;
    int n; // no of child max for any node
    int d; // total no of element
    int pointer; 

    public nth_heap(int size ,int no_of_nodes){
        n = no_of_nodes;
        d = size;
        heap = new Integer[size];
        pointer = 0;
    }
    int Size(){   // return current size
        return pointer;
    }

    int parent(int i){
        return((i-1)/n);
    }

    int child(int i , int k){
        return((i*n)+k );
    }

    boolean isEmpty(){
        return (pointer == 0);   // if n == 0 return true
    }

    public void insert(int key){
 
        heap[pointer] = key;
        swip(pointer);   // calling swap function 
        pointer++;
            
        
    }

    void swip(int i ){  // swping Downtoup or we can call it heapify up
        while(i > 0 && heap[parent(i)] < heap[i]){   //k/2 give parent location 
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    void swipUptoDown(int size){
        int i = 0; int temp; int k;
        while(i<size && heap[i]<heap[child(i, 1)]){
            k = maxchild(i);
            temp = heap[k];
            heap[k] = heap[i];
            heap[i] = temp;
            i = child(i, 1);
        }
    }

    int maxchild(int i ){
        int max = -1 ;
        for( int k = 1 ;k<=n ;k++){
            if(max < heap[child(i, k)]){
                max = child(i, k);
            }
        }
        return max;
    }

    int extractMax(){
        int max;
        
        if(isEmpty()){
            return -1;
        }
        else{
            max = heap[0];
            heap[0] = heap[pointer-1];
            pointer -= 1;   // here pointer is keeping track of current heap size
            swipUptoDown(pointer);   // function thats do re-heapify
            
        }   
        return max;
    }
    void Increase_key(int[] A, int i,int k){
        if(A[i]<k){
            A[i] = k;               // here pointer is keeping track of current heap size
            swipUptoDown(pointer);   // function thats do re-heapify
            
        }
        else{
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        nth_heap q = new nth_heap(6, 3);
        for (int i = 0; i < n; i++) {
            q.insert(input.nextInt());
        }
        System.out.println(q.extractMax());
    }
}
