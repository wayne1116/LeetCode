class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result=0, Min=2147483647;
        for(int i=0; i<nums.length-1; i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int value = nums[i]+nums[left]+nums[right];
                if(value==target) return value;
                else if(value<target) ++left;
                else --right;
                
                //System.out.println(nums[i]+" "+nums[left]+" "+nums[right]+" "+Math.abs(value-target));
                if(Math.abs(value-target)<Min){
                    Min=Math.abs(value-target);
                    result=value;
                }
            }
        }
        return result;
    }
}