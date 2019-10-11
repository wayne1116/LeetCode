class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0) return 0;
        int left = 0;
        int right = nums.length;
        int middle = 0;
        while(left<right){
            middle=(left+right)>>1;
            if(nums[middle]==target) return middle;
            else if(nums[middle]>target) right=middle;
            else left=middle+1;
        }
        return left;
    }
}