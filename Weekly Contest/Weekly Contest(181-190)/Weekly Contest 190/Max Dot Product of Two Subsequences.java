class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length][nums2.length];
        int result=-2147483648;
        for(int i=0; i<nums2.length; i++) {
            dp[0][i]=Math.max(result, nums1[0]*nums2[i]);
            result=Math.max(result, dp[0][i]);
            
        }
        for(int i=1; i<nums1.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0], nums1[i]*nums2[0]);
            result=Math.max(result, dp[i][0]);
        }
        
        for(int i=1; i<nums1.length; i++) {
            for(int j=1; j<nums2.length; j++) {
                int dot=nums1[i]*nums2[j];
                int v1=dp[i-1][j-1]+dot;
                dp[i][j]=Math.max(v1, Math.max(dp[i-1][j], dp[i][j-1]));
                dp[i][j]=Math.max(dp[i][j], Math.max(dot, dp[i-1][j-1]));
                result=Math.max(result, dp[i][j]);
            }
        }
        
        
        return result;
    }
}
