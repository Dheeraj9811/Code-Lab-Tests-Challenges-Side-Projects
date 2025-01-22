public class heapcode {
    public static void main(String[] args) {
        heapcode maxheap = new heapcode(10);

        maxheap.insert(50);
        maxheap.insert(30);
        maxheap.insert(40);
        maxheap.insert(10);
        maxheap.insert(5);
        maxheap.insert(20);
        maxheap.insert(30);
        maxheap.insert(60);
        maxheap.dlt();
        // maxheap.insert(45);

        maxheap.print();
    }
    private int size ;
    private int arr[];
    private int maxsize;

    heapcode(int maxsize){
        this.maxsize = maxsize;
        this.arr = new int[maxsize];
        size = 0;

    }
    int size(){
        return size;
    }
    int parent(int current){

        return (current-1)/2;

    }

    int lchild(int current){

        return 2*current+1;
    }

    int rchild(int curr){
        return 2*curr+2;
    }

    void swap(int current , int location){
        int temp = arr[current];
        arr[current] = arr[location];
        arr[location] = temp;
    }

    void insert(int val){
        size++;
        if(size > maxsize){
            System.out.println("size overflow");
            return;
        }
        if(size == 1){
            arr[size-1] = val;
        }
        else{
            arr[size-1] = val;
            heapify(size-1);
        }

    }
    void dlt(){
        int temp;
        if(size() <= 0) {
            System.out.println("empty");
            return;
        }
        else{
            size--;
            temp = arr[0];
            arr[0] = arr[size];
            heapifydlt();

        }
    }

    void print(){
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    void heapify(int current){
        while(current >0){
            if(arr[current] > arr[parent(current)]){
                swap(current, parent(current));
                current = parent(current);
            }
            else{
                return;
            }
        }
    }

    void heapifydlt(){
        int current = 0;
        while(current<= size()-1) {
            int child = lchild(current) > rchild(current)? lchild(current) : rchild(current);
            if(child >=size()-1) return;
            if(arr[current] < arr[child]){
                swap(current, child);
                current = child;
            }
            else return;

        }
    }


}
