class Solution {
    public int numWays(int steps, int arrLen) {
        int len=Math.min(arrLen, steps/2+1);
        int modu=1000000007;
        int[][] dp=new int[steps+1][len+1];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], 0);
        dp[0][0]=1;
        
        // dp[i][j]: i-th step
        //           j-th position
        for(int i=1; i<=steps; i++){
            // stay & left
            dp[i][0]=(dp[i-1][0]+dp[i-1][1])%1000000007;
            for(int j=1; j<len; j++){
                // stay & left & right
                dp[i][j]=((dp[i-1][j]+dp[i-1][j+1])%modu+dp[i-1][j-1])%modu;
            }
        }
        return dp[steps][0];
    }
}
