import java.util.Scanner;

/**
 * shortestSubseq
 */
public class shortestSubseq {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();

    char a = 0, c = 0, g = 0, t = 0;

    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == 'A') {
            a++;
        }
        if (s.charAt(i) == 'C') {
            c++;
        }
        if (s.charAt(i) == 'G') {
            g++;
        }
        if (s.charAt(i) == 'T') {
            t++;
        }
    }
    int min = s.length();
    String ans = "";

    if (a < min) {
        min = a;
        ans = "A";
    }
    if (c < min) {
        min = c;
        ans = "C";
    }
    if (g < min) {
        min = g;
        ans = "G";
    }
    if (t < min) {
        min = t;
        ans = "T";
    }

    String s1 = "";
    for(int i=0;i<min+1;i++){
        s1 = s1+ans;
    }
    System.out.println(s1);





}
    
}

