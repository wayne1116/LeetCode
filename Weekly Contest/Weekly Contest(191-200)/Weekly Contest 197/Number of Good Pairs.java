class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count=new int[101];
        Arrays.fill(count, 0);
        
        int result=0;
        for(int i=0; i<nums.length; i++) {
            if(count[nums[i]]>0)
                result+=count[nums[i]];
            count[nums[i]]+=1;
        }
        
        return result;
    }
}
