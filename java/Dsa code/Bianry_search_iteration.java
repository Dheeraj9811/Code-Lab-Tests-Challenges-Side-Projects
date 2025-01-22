import java.util.Scanner;

public class Bianry_search_iteration {   // O(log(n)) is worest case  , min time O(1)
    int a = 3 ,b= 4;
    static int Bin_search(int arr[],int key, int e){
        int s = 0; 
        e = e-1;

        while(s<=e){
            int mid = (s+e)/2;
            if (key == arr[mid] ){
                return mid+1;
            }

            if (key < arr[mid]) {
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }return -1;
    }

    static int Bin_search_recursive(int arr[],int key,int s , int e){ 
        
        e = e-1;
        // smale case
        if(e>= s){
            int mid = (s+e)/2;
            if(arr[mid] == key){
                return mid+1;
            }
            else{
            
            
                if(key < arr[mid]){
                    return Bin_search_recursive(arr, key, s, mid-1);
                }else{
                    return Bin_search_recursive(arr, key, mid+1, e);
                }
            }

        }
            
        


    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n ;
        n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            
        }
        System.out.println(Bin_search(arr, 16, n));
        System.out.println(Bin_search_recursive(arr, 16,0, n));
        in.close();

    }
    
}
