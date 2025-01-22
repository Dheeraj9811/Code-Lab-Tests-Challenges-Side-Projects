import java.util.Scanner;

public class DuplicateWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String input ="" ;
        
        while (n >= 0) {
            input = in.nextLine().trim();
            String[] temp = input.split(" ");
            for( int i = 0 ; i < temp.length; i++){
                if( temp[i] != "null" ){
                    for (int j = i+1 ; j < temp.length ; j++){
                        
                        if(temp[i].toLowerCase().equals(temp[j].toLowerCase())){
                            temp[j] = "null";
                        }
                    }
                }
            }
            for (String string : temp) {
                if(string != "null")
                System.out.print(string + " ");
                             
            } System.out.println("");

            n--;
            
        }
    }
    
}
