class Solution {
    public int maxSumDivThree(int[] nums) {
        int[][] dp=new int[nums.length][3];
        dp[0][0]=dp[0][1]=dp[0][2]=0;
        int mod=nums[0]%3;
        dp[0][mod]=nums[0];
        
        for(int i=1; i<nums.length; i++){
            mod=nums[i]%3;
            for(int j=0; j<3; j++){
                dp[i][j]=dp[i-1][j];
                if(dp[i-1][(j-mod+3)%3]>0) dp[i][j]=Math.max(dp[i][j], dp[i-1][(j-mod+3)%3]+nums[i]);
                if(j==mod) dp[i][j]=Math.max(dp[i][j], nums[i]);
            }
        }
        return dp[nums.length-1][0];
    }
}
