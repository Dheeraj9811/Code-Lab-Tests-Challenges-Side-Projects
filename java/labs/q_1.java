import java.util.Scanner;

public class q_1 {
    public static void main(String[] args) {
        String original, reverse = "";
        Scanner in = new Scanner(System.in);
        original = in.nextLine();
        int length = original.length();
        for ( int i = length - 1; i >= 0; i-- )
            reverse = reverse + original.charAt(i);
        if (original.equals(reverse))
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}
        