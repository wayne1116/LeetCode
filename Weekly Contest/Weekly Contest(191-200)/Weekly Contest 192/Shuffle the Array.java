class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result=new int[nums.length];
        for(int i=0; i<n; i++)
            result[i*2]=nums[i];
        int j=0;
        for(int i=n; i<nums.length; i++){
            result[j*2+1]=nums[i];
            ++j;
        }
        
        return result;
    }
}
