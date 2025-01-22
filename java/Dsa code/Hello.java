public class Hello {
    
    public static void main(String[] args) {
        int a = 3, b = 4 ;
        int n = 6;
        int upper = a*n;
        int low = a ;
        while(low<=upper){
            int mid =(low+upper)/2;
            int temp = mid/a + mid/b - mid/(a*b);
            if (mid/a + mid/b - mid/(a*b) == n)  {
                System.out.println(mid);
            }
            else if(temp < n){
                low = mid +1;
            }
            else if (temp > n ){
                upper = mid-1;
            }
        }        

    }
}
3 4 6 8 15 16