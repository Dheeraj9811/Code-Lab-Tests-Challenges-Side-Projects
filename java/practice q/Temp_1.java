import java.util.Scanner;

public class Temp_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String input_2 = "";
        in.close();
        input = input.trim();
        Boolean flag = false;

        for (int i = 0 ; i < input.length() ; i++){
            if( ( (int) input.charAt(i) >= 65 && (int) input.charAt(i) <= 90 ) || (  (int) input.charAt(i) >= 97 && (int) input.charAt(i) <= 122 )  ){

                input_2 = input_2 + input.charAt(i);
                flag = true;
            }
                else{
                    input_2 = input_2 + " " ;
                }
        }
        if (flag == false) 
        System.out.println(0);
        else{
            input_2 = input_2.trim();
        String[] array = input_2.split("\\p{Space}+") ;
        System.out.println(array.length);
        for (String a : array )
        System.out.println(a);

        }
        

    }
    
}
