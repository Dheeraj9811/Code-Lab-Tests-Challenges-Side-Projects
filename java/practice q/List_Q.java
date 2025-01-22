
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class List_Q {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N ,Q,a ,b;
        String x ;
        N = in.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(in.nextInt());
            
        }
        Q = in.nextInt();
        in.nextLine();
        while (Q-- >= 0){
            
            x = in.nextLine();

            if( x.equals("Insert")){
                a = in.nextInt(); b = in.nextInt();
                list.add(a, b);
            }
            else if (x.equals("Delete")){
                a = in.nextInt();
                list.remove(a);
            }
        }
        for (Integer integer : list) {
            System.out.print(integer+" ");
            
        }
            
        in.close();
            
        

    }
    
}
