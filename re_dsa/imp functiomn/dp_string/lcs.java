import java.util.*;

class lcs{
     public static void main(String args[]) {

    String s1= "aaaaaaaa";
    String s2= "aaaaaaaa";
                                    
    System.out.println("The Length of Longest Common Subsequence is "+lcstabulation(s1,s2));
    }
    static int lcsUtil(String s1, String s2, int i, int j, int[][] dp){

        if(i==0 || j==0)
            return 0;
            
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        if(s1.charAt(i-1) == s2.charAt(j-1))
            return dp[i][j] = 1 + lcsUtil(s1,s2,i-1,j-1,dp);
        
        else 
            return dp[i][j] = 0 + Math.max(lcsUtil(s1,s2,i,j-1,dp),
            lcsUtil(s1,s2,i-1,j,dp));
    
    }
    static int lcstabulation(String s1, String s2) {
    
        int n=s1.length();
        int m=s2.length();
    
        int dp[][]=new int[n+1][m+1];
        
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = 0 + Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        // // print the lcs string code using stringbuilder
        // StringBuilder sb = new StringBuilder();
        // int i=n,j=m;
        // while(i>0 && j>0){
        //     if(s1.charAt(i-1)==s2.charAt(j-1)){
        //         sb.append(s1.charAt(i-1));
        //         i--;
        //         j--;
        //     }
        //     else{
        //         if(dp[i-1][j]>dp[i][j-1])
        //             i--;
        //         else
        //             j--;
        //     }
        // }
        // System.out.println(sb.reverse().toString());
    
        return dp[n][m];
    }

    


    static int lcs(String s1, String s2) {
        
        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];
        for(int rows[]: dp)
        Arrays.fill(rows,-1);
        return lcsUtil(s1,s2,n,m,dp);
    }

   
}