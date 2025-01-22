// package sliding window;

import java.util.HashMap;
import java.util.Map;

class min_window_substring {
    public String minWindow(String s, String t) {
        int map[] = new int[127];
        // making map to store t
        int count = 0;
        for(char a : t.toCharArray()){
            if(map[(int)a]++ == 0) count++;
            
        }
        
        // to make contains like hashmap, if(map) != (int)-1e5 then its contains that number
        for(int i = 0;i<127;i++){
            if(map[i] == 0) map[i] = (int)-1e5;
        }
        int i=0,j=0;
        int ans = (int)1e5;
        char arr[] = s.toCharArray();
        int n = arr.length;
        int ansi = -1,ansj = -1;
        while(j<n){
            int c = (int)arr[j];
            if(map[c] != (int)-1e5 ){
                map[c]--;
                if(map[c] == 0) count--;
                
            }
            
            if(count == 0){
                
                while(count == 0 && i<=j){
                    if(ans>j-i+1){
                        ans = j-i+1;
                        ansi = i;
                        ansj = j;
                    }
                    int d = arr[i];
                    if(map[d] != (int)-1e5){
                        map[d]++;
                        if(map[d] == 1){
                            count++;

                        } 
                    }
                    i++;
                    // if(count == 0){
                    //     ans = Math.min(ans,j-i+1);
                    // }
                }
                
            }
            j++; 

        }
        return (ans == (int)1e5 ? "" :s.substring(ansi,ansj+1));

    }


    public static void main(String[] args) {
        min_window_substring s = new min_window_substring();
        System.out.println(s.minWindow("ADOBECODEBANC","ABC"));
    }
}
