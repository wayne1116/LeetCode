// 1567. Maximum Length of Subarray With Positive Product
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-204/problems/maximum-length-of-subarray-with-positive-product/

class Solution {
    public int getMaxLen(int[] nums) {
        int result=0;
        int count1=0, count2=0;
        int negCount=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==0) {
                count1=0;
                count2=0;
                negCount=0;
            }
            else if(nums[i]>0) {
                if(negCount>0)
                    ++count2;
                else
                    ++count1;
                if(negCount%2==0)
                    result=Math.max(result, count1+count2+negCount);
                else
                    result=Math.max(result, count2+negCount-1);
            }
            else{
                if(negCount%2==1)
                    result=Math.max(result, count1+count2+negCount+1);
                else
                    result=Math.max(result, count2+negCount);
                ++negCount;
            }
        }
        
        return result;
    }
}
