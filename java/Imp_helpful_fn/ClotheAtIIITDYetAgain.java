import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ClotheAtIIITDYetAgain {
    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        long t = Reader.nextlong();

        for(int i = 0; i < t; i++) {
            long n = Reader.nextlong();
            long m = Reader.nextlong();
            long size = n+m;
            long[] dress = new long[(int) size];
            for(long j = 0; j < size; j++) {
                dress[(int) j] = Reader.nextlong();
            }

        boolean flag = false;

            for(long l = n; l < size; l++) {
                for(long k = 0; k < n; k++) {
                    if(dress[(int) k] == dress[(int) l]) {
                        System.out.println("YES");
                        flag = true;
                    }
                }
                if(!flag) {
                    System.out.println("NO");
                }
                else {
                    flag = false;
                }
            }
        }
    }
}


class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextint() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextlong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextdouble() throws IOException {
        return Double.parseDouble(next());
    }
}
