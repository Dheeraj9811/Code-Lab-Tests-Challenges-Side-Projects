public class palindrome {
    
    static boolean isPalindrome(int s, int l , String str){
        if(s >=l){
            return true;
        }
        if(str.charAt(s) != str.charAt(l)){
            return false;
        }
        return isPalindrome(s+1, l-1, str);
    }

    static void powerSet(String str, int index, String curr){
        int n = str.length();
        if(index == n){
            System.out.println(curr);
            return;
        }
        powerSet(str, index+1, curr+str.charAt(index));
        powerSet(str, index+1, curr);
    }


    static String swap(String str, int i, int j)
    {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
    //  print all permutation of a string

    static void permute(String str, int l, int r){
        if(l == r){
            System.out.println(str);
        }
        else{
            for(int i = l; i<=r; i++){
                str = swap(str, l, i);
                permute(str, l+1, r);
                str = swap(str, l, i);
            }
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        // System.out.println(isPalindrome(0, str.length()-1, str.toLowerCase()));
        // powerSet(str, 0, "");
        permute(str, 0, str.length()-1);
    }
}
