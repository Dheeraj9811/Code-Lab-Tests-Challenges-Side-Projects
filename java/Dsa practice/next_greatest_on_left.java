import java.util.Stack;
// not working right now because debuging requird
public class next_greatest_on_left {

    static int[] Ngol(int[] arr){
        Stack<Integer> st = new Stack<>();
        int [] answer = new int[arr.length];
        int count = 0;

        st.push(0);
        answer[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if(!st.empty()){
                int temp = 0;
                while(!st.empty() && arr[i] > arr[(int) st.peek()]){
                    st.pop();
                    temp++;

                }
                answer[i] = temp;
            }else if(st.empty()){
                answer[i] = i+1;
            } 
            
                st.push(i);
            
        }
        return answer;
    }
    
    public static void main(String[] args) {
        int[] arr = {1 ,2,4,10,5,7,3} ;
        int [] a = Ngol(arr);
        System.out.println();
    }
}
