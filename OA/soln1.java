import java.util.*;

public class soln1 {
    int solve(int arr[][]){
        int n = arr.length;
        // int count = 0;
        // if there is only one meeting then return 1
        
        if(n == 1){
            return 1;
        }

        Arrays.sort(arr, (a,b)->a[0]-b[0]); // n logn

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);  // start time - arr[i][0] ands end time = arr[i][1];
        
        for(int i = 1;i<n;i++){ // n*logn
            if(arr[i][0] >= pq.peek()){
                pq.poll();
            }
            
                // count++;
                pq.add(arr[i][1]);
            

        }

        return  pq.size();

    }
    // tc: 

    Node reverse(Node head){
        Node  curr = head; 
        Node prev = null;
        Node next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        prev;
    }

    


    public static void main(String[] args) {
        int n = 3;
        int[][] arr = new int[n][2];

        Scanner sc = new Scanner(System.in);

        for(int i = 0;i<n;i++){
            System.out.println("Enter the start time and end tme of meet");
            for(int j = 0;j<2;j++){
                arr[i][j] = sc.nextInt();
            }

        }
// test caswe  [1,5] , [4,6] , [7,8], [8,15] , [5,10]
// Input : [[0,23], [15,20], [5,10]]
// [0,23] , [5,10] , [15,20]
        // calling the solve function
        soln1 s = new soln1();
        System.out.println(s.solve(arr));


    }
}
