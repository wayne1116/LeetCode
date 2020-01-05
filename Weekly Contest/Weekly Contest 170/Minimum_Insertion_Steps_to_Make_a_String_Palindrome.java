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
