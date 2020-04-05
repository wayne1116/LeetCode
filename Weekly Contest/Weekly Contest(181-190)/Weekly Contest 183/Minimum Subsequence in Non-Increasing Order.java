class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int total=0;
        for(int i=0; i<nums.length; i++)
            total+=nums[i];
        
        List<Integer> result=new LinkedList<Integer>();
        int sum=0;
        for(int i=nums.length-1; i>=0; i--){
            if(sum<=total){
                sum+=nums[i];
                result.add(nums[i]);
                total-=nums[i];
            }
        }
        
        return result;
    }
}
