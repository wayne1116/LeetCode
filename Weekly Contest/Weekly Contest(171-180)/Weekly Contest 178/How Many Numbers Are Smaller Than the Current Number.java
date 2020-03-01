class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count=new int[128];
        Arrays.fill(count, 0);
        for(int i=0; i<nums.length; i++)
            ++count[nums[i]];
        
        for(int i=1; i<=100; i++)
            count[i]+=count[i-1];
        
        int[] result=new int[nums.length];
        for(int i=0; i<nums.length; i++)
            result[i]=nums[i]==0?0:count[nums[i]-1];
        return result;
    }
}
