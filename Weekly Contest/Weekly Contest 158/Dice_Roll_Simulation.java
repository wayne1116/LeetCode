class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        long[][] dp = new long[n][7];
        for(int i=0; i<6; i++) dp[0][i]=1;
        dp[0][6]=6;
        
        for(int i=1; i<n; i++){
            long temp = 0;
            for(int j=0; j<6; j++){
                dp[i][j]=dp[i-1][6];
                if(i-rollMax[j]<0){
                    temp = (temp+dp[i][j])%1000000007;
                }
                else{
                    if(i-rollMax[j]>0){
                        long dect = dp[i-rollMax[j]-1][6] - dp[i-rollMax[j]-1][j];  // Assuming restriction for 1 is 2 times
                        dp[i][j] = (dp[i][j]-dect+1000000007)%1000000007;           // axxb, b:current location
                    }                                                               // a11 : dp[i-rollMax[j]-1][6] - dp[i-rollMax[j]-1][1], a: 2~6
                    else dp[i][j]=(dp[i][j]-1)%1000000007;                          
                    temp = (temp+dp[i][j])%1000000007;
                }
            }
            dp[i][6]=temp;
        }
        return (int)dp[n-1][6];
    }
}
