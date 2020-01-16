class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left=1;
        int right=1000000;
        while(left<right){
            int middle=(left+right)>>1;
            int sum=0;
            for(int i=0; i<nums.length; i++){
                if(nums[i]%middle!=0) sum=sum+nums[i]/middle+1;
                else sum=sum+nums[i]/middle;
            }
            if(sum>threshold) left=middle+1;
            else right=middle;
        }
        return right;
    }
}
