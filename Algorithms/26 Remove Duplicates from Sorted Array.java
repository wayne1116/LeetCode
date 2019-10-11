class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int result =1;
        int flag;
        flag=nums[0];
        for(int i=1; i<nums.length; i++){
            if(flag!=nums[i]){
                nums[result++]=nums[i];
                flag=nums[i];
            }
        }
        return result;
    }
}