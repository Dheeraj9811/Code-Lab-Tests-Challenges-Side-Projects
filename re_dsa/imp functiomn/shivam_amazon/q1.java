package shivam_amazon;

public class q1 {
    public static void main(String[] args) {
        String a = "AB";
        String b = "BD";
        String c = "CD";
        int small = smallest(a,b,c);
        System.out.println(small);
        int n = a.length();
        char remove = (char)c.charAt(small);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            sb.append('[');
            for(int j = 0;j<26;j++){
                if(i == small && (char)(j+'A') == remove )continue;
                sb.append((char)(j+'A'));
            }
            sb.append(']');
        }

        System.out.println(sb.toString());

    }

    static int smallest(String a ,String b,String c){
        int n = a.length();
        int min = 0;
        char minch = 'Z';
        for(int i = 0;i<n;i++){
            if(a.charAt(i) == c.charAt(i) || b.charAt(i) == c.charAt(i)){
                continue;
            }
            else{
                // min = Math.min(c.charAt(i),min);
                if(c.charAt(i)<minch){
                    min = i;
                }
            }
        }

        return min;
    }
}

