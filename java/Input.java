import java.util.Scanner;

public class Input {// input from user 
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Scanner is FN which provide input methods
        System.out.print("age : ");
        byte age = input.nextByte();            // we use next key to input 
        System.out.println("your age is = " + age);


    
        System.out.print("Name : ");
        String Name = input.next();            // we use next key to input string buter here it take single word as input
        System.out.println("your Name is = " + Name); 
        input.nextLine(); // Actually nextLine() method of Scanner skips the console input, when we use it after next(), nextInt() and all nextXXX() methods
// to slove this add extra nextline after next() or nextxxx
        // Because next() and nextXXX() input methods doesn’t process/consider the newline character (When you press ENTER key after input them)
        
        System.out.print("full Name : ");
        String fName = input.nextLine();            // we use next key to input string buter here it take single line as input
        System.out.println("your Full name is = " + fName);


    }
}
