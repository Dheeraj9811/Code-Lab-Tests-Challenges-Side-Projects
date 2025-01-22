import java.util.*;

public class q1_1 {
    void solve(ArrayList<Integer> arr , int val){
        int n  = arr.size();
        boolean flag = false;
        for(int i = 0;i<n;i++){
            if(arr.get(i) <val  ){
                continue;
            }
            else{
                // add at this index;
                arr.add(i,val);
                flag = true;
                break;
            }
        }

        if(!flag){
            arr.add(val);
        }


    }

    int bs(ArrayList<Integer> arr , int val, int low , int high){
        while(low<= high){
            int mid = low + (high-low)/2;
            if(arr.get(mid) == val){
                return mid+1;
            }
            else if(arr.get(mid)<val){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }


        return low;
    }

    void helper(ArrayList<Integer> arr , int val){
        int n = arr.size();
        int index  = bs(arr,val,0,n-1);
        arr.add(index,val);
    }

    public static void main(String[] args) {
        q1_1 obj = new q1_1();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        arr.add(11);
        arr.add(12);
        int val = 15;
        obj.helper(arr, val);
        int val2 = 13;
        obj.helper(arr, val2);


        for(int i = 0;i<arr.size();i++){
            System.out.print(arr.get(i) + " ");
        }
    }
}


