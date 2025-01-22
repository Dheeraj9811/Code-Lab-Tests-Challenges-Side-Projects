package template;

/* package codechef; // don't place package name! */

import java.util.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static FastReader st = new FastReader();
    static PrintWriter out=new PrintWriter(System.out);
        
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		int t = st.nextInt();
		while(t-- >0)
		{
		    
            out.flush();
    		out.close();   
		}
		
	}

	static void inputarr(int[] arr){
	    for(int i =0;i<arr.length;i++){
	        arr[i] = st.nextInt();
	    }
	}
	
	static void printarr(int[] arr){
	    for(int i : arr){
	        out.print(i+" ");
	    }
	    out.println();
	    out.flush();
	}

    static boolean[] prime(int n){
        boolean[] arr = new boolean[n+1];
        for(int i=0;i<=n;i++){
            arr[i] = true;
        }
        arr[0] = false;
        arr[1] = false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(arr[i]){
                for(int j=i*i;j<=n;j+=i){
                    arr[j] = false;
                }
            }
        }
        return arr;
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
                end =  mid-1;
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
	
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
  
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
  
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
  
        int nextInt() { return Integer.parseInt(next()); }
  
        long nextLong() { return Long.parseLong(next()); }
  
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
  
        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


}

