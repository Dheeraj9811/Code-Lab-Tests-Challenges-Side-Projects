import java.util.Scanner;

public class C1 {
    public static void main(String[] args) {
        int N ,k;
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        k = input.nextInt();
        int[] arr = new int[N];
        int sum= 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = input.nextInt();
            
        }
        for (int i = 0; i < N; i++) {
            for(int j = 0 ;j< n ; j++ ){
                sum += arr[i];
                if(sum>= k){
                    count++;
                    break;
                }
            }
            
        }
    }
}
