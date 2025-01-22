import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public static String reorganizeString(String s) {
        StringBuilder str = new StringBuilder(s);
        int i =0 , j =1 , n = s.length();
        while(i< n){
            int flag =0;
            while( j<n  && str.charAt(i) == str.charAt(j ) ) {
                System.out.println(i + " " + j);
                j++;
                flag =1; // to tell if ander isliye gaya bcz same element th next
            }
            if(j<n && flag == 1){
                str.insert(i+1 , str.charAt(j));
                str.delete(j+1,j+2);
                i = i+1;
                j = i+1;
            }
            else if(j>= n && flag==1) return "";
            else{
                j++;i++;
            }
            
        }
        return str.toString();
    }

 



    public static void main(String[] args) {
        String arr1 ="aab";
        

        System.out.println(reorganizeString(arr1));
        
        
            
            
    }

}
class node{
    int data;
    int key;
    node next;
    
    node(int key , int data){
        this.key = key;
        this.data = data;
        this.next = null;
    }
}