class Solution {
    public int numOfArrays(int n, int m, int k) {
        long[][][] dp=new long[n+1][m+1][k+1];
        long mod=1000000007;
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++)
                Arrays.fill(dp[i][j], 0);
        }
        
        for(int i=1; i<=m; i++)
            dp[1][i][1]=1;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                for(int l=1; l<=k; l++){
                    dp[i][j][l]+=j*dp[i-1][j][l];
                    for(int a=1; a<=j-1; a++)
                        dp[i][j][l]+=dp[i-1][a][l-1];
                    dp[i][j][l]%=mod;
                }
            }
        }
        
        long result=0;
        for(int i=0; i<=m; i++)
            result+=dp[n][i][k];
        
        return (int)(result%1000000007);
    }
}
