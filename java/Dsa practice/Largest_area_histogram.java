import java.util.Stack;

public class Largest_area_histogram { // 6 2 5 4 5 1 6 
    static int La(int[] arr){   // we will find nearest smallest element from right and left 
        if(arr.length-1 == 0 ){ // this is edge case
            return arr[0];
        }
        else{
            int rs [] = new int[arr.length]; // we store index here 
            int ls [] = new int[arr.length];
            
            Stack<Integer> st = new Stack<>();
            // finding smallest to right 
            int l = arr.length;
                st.push(l-1);
                rs[l-1] = l;
            for (int i =arr.length - 2; i >= 0; i--){
                

                while(!st.empty() && arr[i] <=arr[st.peek()] ){
                    st.pop();
                }
                if(st.empty()){  // may be come out of loop buz stack become empty so no smaller found on right 
                    rs[i] = l;

                } else{ // out of loop bcz now cant pop anymore stack as smaller value so top is the smallest value on right  
                    rs[i] = st.peek();
                }
                st.push(i);
            }

            st = new Stack<>();
            // find smallest to left 
            st.push(0);
            ls[0] = -1;
            for(int i = 0; i < arr.length;i++) {
                while(!st.empty() && arr[i] <=arr[st.peek()] ){
                    st.pop();
                }
                if(st.empty()){  // may be come out of loop buz stack become empty so no smaller found on left
                    ls[i] = -1;
                } else{ // out of loop bcz now cant pop anymore stack as smaller value
                    ls[i] = st.peek();
                }
                st.push(i);
            }
            int maxArea = 0;
            
            for(int i = 0; i < arr.length; i++){
                int width = rs[i] - ls[i] -1;
                int area = arr[i]* width;
                if(area > maxArea){
                    maxArea = area;
                } 
            }
            return maxArea;
        }
    }

    public static void main(String[] args) {
        int arr[]= {9,0};
        System.out.println(La(arr));
    }
}
