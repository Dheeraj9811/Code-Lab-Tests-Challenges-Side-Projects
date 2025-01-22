// package binary_search;

public class bs {

    public static void main(String[] args) {
        int[] arr = {1,4,7,10};
        int target = 2;
        // System.out.println(justGreater(arr,target));
        System.out.println(justSmaller(arr,target));
        // System.out.println(binarySearch(arr,target));
    }
    // just great or equall
    static int bsjgoreq(int currindex,int value[][]){
        int l = currindex+1;
        int n = value.length;
        int r = n-1;
        int ans = n+1;
        int t = value[currindex][1];
        while(l<=r){
            int mid = l+(r-l)/2;
            
            if(value[mid][0]<t){
                l = mid+1;
            }
            else{ 
                // if(value[mid][0]>=t)
                r = mid-1;
                ans = mid;
            }
        }
        return ans;
    }
    static int justGreater(int[] arr, int target){
        
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        
        while(start<=end){
            
            int mid = start + (end-start)/2;
            
            if(arr[mid] == target){
                start =  mid+1;
            }
            else if(arr[mid] > target){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }

    // just smaller than target
    static int justSmaller(int[] arr, int target){
        
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        
        while(start<=end){
            
            int mid = start + (end-start)/2;
            
            if(arr[mid] == target){
                return mid-1;
            }
            else if(arr[mid] > target){
                end = mid-1;
            }
            else{
                ans = mid;
                start = mid+1;
            }
        }
        return ans;
    }
    // binary search for the target
    static int binarySearch(int[] arr, int target){
        
        int start = 0;
        int end = arr.length-1;
        
        while(start<=end){
            
            int mid = start + (end-start)/2;
            
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
    // fastest function to find e Minimum Excluded (MEX) in Array list
    
    
    
}

// function to find just greater than to the target return -1 if not found else index


