import java.util.Scanner;

public class SWItch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.println("choose number bw 1 to 3");
        Integer  enter = input.nextInt();

        switch (enter) {
            case 1 : 
                System.out.println("you have choose 1");
                
                break;
            case 2 :
                System.out.println("you have choose 2 ");
                break;
        
            default:
            System.out.println("you have choose 3 ");
                break;
        }
    }
}
