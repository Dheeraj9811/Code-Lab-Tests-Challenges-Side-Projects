

public class Array_Q {
    public static void main(String[] args) {
        int q, n,leap,temp;
        
        
        Scanner in = new Scanner(System.in);
        q = in.nextInt();
        while (q-- >0){

            n = in.nextInt();
            leap = in.nextInt();
            int arr[] = new int[n];
            temp = 0;

            for(int i =0 ; i< n; i++ ){
                arr[i] = in.nextInt();
               
            }
            Boolean tell = false;
            int j = 0;
            while (j < n) {                 
                if (arr[0] == 1 ) // checking base condition first element 1 na ho verna aage he nhi move kr skte game over
                break;

                if(j+leap<n && arr[j + leap] ==0){  // checking leap +j smaller than array size and jump place pr zero ho
                    j = j+leap;
                    arr[j] =1 ;

                }else if (j+leap>=n){  // aagr j + leap greater = than n  we win acc to condition 
                    tell = true;
                    break;
                }else if (arr[j+1] == 0 ){ // else ab one option raha  gaya j+1 aagr uper se kuch bhi nhi work kiya 
                    j = j+1;
                    arr[j] =1;
                }
                else if (j-1 >= 0 && arr[j-1] == 0   ) // base case of leap+j  jump aagr forward jump na kr pa rahe  to ek back ka case check krna ki 0 ho to vaha se jump maare 
                    j = j-1;
                else 
                break;
                

                
            }
            if( tell == true)
            System.out.println("YES");
            else
            System.out.println("NO");

            

        }

    }
    
}
