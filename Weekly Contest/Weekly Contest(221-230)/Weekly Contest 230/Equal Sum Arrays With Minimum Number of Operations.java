// 1775. Equal Sum Arrays With Minimum Number of Operations
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-230/problems/equal-sum-arrays-with-minimum-number-of-operations/

class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if(nums1.length*6<nums2.length || nums1.length>nums2.length*6)
            return -1;
        
        int sum1 = 0;
        for(int i=0; i<nums1.length; i++)
            sum1 += nums1[i];
        int sum2 = 0;
        for(int i=0; i<nums2.length; i++)
            sum2 += nums2[i];
        
        if(sum1>sum2)
            return minOperations(nums2, nums1);
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left = 0;
        int right = nums2.length-1;
        int diff = sum2 - sum1;
        int result = 0;
        while(diff>0) {
            if(right<0 || nums2[right]-1<6-nums1[left])
                diff -= (6 - nums1[left++]);
            else
                diff -= (nums2[right--]-1);
                
            ++result;
        }
        
        return result;
    }
}
