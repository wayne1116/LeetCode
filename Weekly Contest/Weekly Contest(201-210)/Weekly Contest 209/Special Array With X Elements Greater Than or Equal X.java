// 1608. Special Array With X Elements Greater Than or Equal X
// difficulty: easy
// website: https://leetcode.com/contest/weekly-contest-209/problems/special-array-with-x-elements-greater-than-or-equal-x/
class Solution {
    public int specialArray(int[] nums) {
        for(int i=nums.length; i>0; i--) {
            int count=0;
            for(int j=0; j<nums.length; j++) {
                if(nums[j]>=i)
                    ++count;
            }
            if(count==i)
                return count;
        }
        
        return -1;
    }
}
