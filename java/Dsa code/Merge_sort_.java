public class Merge_sort_ {
    static void merge_shot(int [] A, int l ,int h ){
        if(l<h){
            int mid = (l+h)/2;
            merge_shot(A, l, mid);
            merge_shot(A, mid+1, h);
            merge(A, l, mid, h);

        }
    }

    static void merge(int A[],int mid,int l,int h){

        int i , j , k ; int [] temp = new int[h+1];
        i = l ; j = mid+1 ; k = h;

        while( i <= mid && j<=h){
            if(A[i] < A[j]){
                temp[k] = A[i];
                i++ ; k++ ;
            }else {
                temp[k] = A[j];
                j++ ; k++ ;
            }
        }    
        if(i > mid){
            while(j<h){
                temp[k] = A[j] ;
                k++ ; j++ ;
            }
        }else{
            while(i<= mid){
                temp[k] = A[i];
                k++ ; i++;
            }
        }
        for ( k = l; k <= h; k++) {
            A[i] = temp[i];
        }   
            
            
        
        
    }
    public static void main(String[] args) {
        int [] arr = {12 ,21,22,5,14,18,21,35,40,1};
        merge_shot(arr, 0, 10);
        for (int x : arr) {
            System.out.println(x);
        }
        
    }
    
}
