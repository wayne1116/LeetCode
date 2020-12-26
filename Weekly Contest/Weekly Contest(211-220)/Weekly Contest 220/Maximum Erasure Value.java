// 1695. Maximum Erasure Value
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-220/problems/maximum-erasure-value/

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1; i<nums.length; i++)
            dp[i] = dp[i-1] + nums[i];
        
        int result = 0;
        int index = -1;
        int[] location = new int[10001];
        Arrays.fill(location, -1);
        for(int i=0; i<nums.length; i++) {
            if(location[nums[i]]!=-1) {
                index = Math.max(index, location[nums[i]]);
            }
            
            if(index==-1)
                result = Math.max(result, dp[i]);
            else
                result = Math.max(result, dp[i]-dp[index]);
            location[nums[i]] = i;
        }
        
        return result;
    }
}
