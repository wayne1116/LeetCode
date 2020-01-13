class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] dp = new int[nums.length+2];
        int count=1;
        dp[0]=-1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==1) dp[count++]=i;
        }
        dp[count]=nums.length;
        if(count==1 || count-1<k)
            return 0;
        
        int result=0;
        int j=1;
        for(int i=k; i<count; i++, j++){
            result=result+(dp[j]-dp[j-1])*(dp[i+1]-dp[i]);
        }
        return result;
    }
}
