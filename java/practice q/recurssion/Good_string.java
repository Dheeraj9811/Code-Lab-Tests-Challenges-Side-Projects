import java.util.Scanner;

public class Good_string {

    static String Nice_string(String str,int n ){
        if(n <=1){
            return str;
        }
        if(str.charAt(0)== str.charAt(1) ){
            return Nice_string(str.substring(1),n-1);
        }else{
            return str.charAt(0) + Nice_string(str.substring(1),n-1);
        }
    }
    
    public static void main(String[] args)  {
        int x ;
        String word ;
        Scanner in = new Scanner(System.in);
        x = in.nextInt();

        word = in.next();
        System.out.println(Nice_string(word, x));



        
    }
    
}
