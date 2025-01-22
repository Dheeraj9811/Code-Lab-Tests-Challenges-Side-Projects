public class Q6_b {

    static void nearestLarger(int arr[], int n){
        Mystack stack = new Mystack();
        int temp_arr[] = new int[n];
        int i;
        for( i = n-1; i>=0 ; i-- ){
            
            if(!stack.isempty()){
                
                while(!stack.isempty() && arr[stack.peek()]<= arr[i]){
                    
                    stack.pop();
                }
            }
            if(stack.isempty()){
                temp_arr[i] = -1;
            }
            else
            temp_arr[i] = stack.peek();

            stack.push(i);

        }
        for (int j = 0; j < n; j++) {
            if(temp_arr[j] != -1){
                System.out.print((temp_arr[j]+1) + " ");
            }
            else
            System.out.print(temp_arr[j] + " ");
        }
        int count_line = 1;
        System.out.println();
        for (int z : temp_arr) {
            if(z != -1){
                System.out.println("For player at index" + count_line + " the nearest friend is at index " + (z+1) + " having a match value " + arr[z]);
                
            }
            else
            System.out.println("For player at index" + count_line + " there is no nearest friend found ");
            count_line++;
        }

          
    }

    public static void main(String[] args) {
        int arr[]= {2,5,9,3,1,12,6,8,7};
        nearestLarger(arr, arr.length);
            
    }

     
    
    
}
class Mystack{
    listNode Top;
    int length;

     class listNode{
        int data;
        listNode next;

        public listNode(int data){
            this.data = data;
        }
    }
    public Mystack(){
        Top = null;
        length = 0;
    }
    public int length(){
        return length;
    }
    public boolean isempty(){
        return length ==0 ;
    }

    public void push(int data){
        listNode temp = new listNode(data);
        temp.next = Top;
        Top = temp;
        length++;
        
    }
    public int pop(){
                                                                                /*if(Top == null){
                                                                                System.out.println("stack is empty ");
                                                                            }*/
        if(isempty()){
            System.out.println("stack is empty");
        }
        int result = Top.data;
        Top = Top.next;
        length--;
        return result;
    }
    public int peek(){
        if(isempty()){
            System.out.println("stack is empty");
            
        
        
        }
            return Top.data;
        
    }
    

}
