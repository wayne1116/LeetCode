class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i=0;
        while(i<nums.length){
            if(nums[i]==1)
                break;
            ++i;
        }
        
        int min_value=Integer.MAX_VALUE;
        for(int j=i+1; j<nums.length; j++) {
            if(nums[j]==1){
                min_value=Math.min(min_value, j-i-1);
                i=j;
            }
        }
        
        return min_value>=k;
    }
}
