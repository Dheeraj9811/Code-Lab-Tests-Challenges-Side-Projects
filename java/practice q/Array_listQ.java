import java.util.ArrayList;
import java.util.Scanner;

public class Array_listQ { 
    public static void main(String[] args) {
        //ArrayList<Integer> array = new ArrayList<Integer>(); how to initaill 1d array
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();  //2D array
        
        int n , d ;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0 ; i<n ; i++){
            d = in.nextInt();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            while(d-- >0){
            temp.add(in.nextInt());
            }
            array.add(temp);
            
            
            
        }
        System.out.println(array.size());
        System.out.println(array.get(1).get(2));
        
        
    }
    
}
