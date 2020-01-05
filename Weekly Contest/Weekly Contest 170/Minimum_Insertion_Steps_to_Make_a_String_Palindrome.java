// LCS
class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<s.length()+1; i++) dp[i][0]=dp[0][i]=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1)==s.charAt(n-j)) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return n-dp[n][n];
    }
}

/* recursive
class Solution {
    int [][] dp;
    int solv(int s, int e, String line)
    {
        if(s>=e) return 0;
        if(dp[s][e]!=-1) return dp[s][e];
        return dp[s][e]=(line.charAt(s)==line.charAt(e)?solv(s+1,e-1,line):1+Math.min(solv(s+1,e,line),solv(s,e-1,line)));
        // Two case
        // 1. insert one character at e to match the character at s
        // 2. insert one character at s to match the character at e
    }
    public int minInsertions(String s) {
        int n=s.length();
        dp=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) dp[i][j]=-1;
        }
        return solv(0, n-1, s);
    }
}
*/
