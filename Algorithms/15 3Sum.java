class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        int i = 0;
        int jump;
        
        while(i<nums.length-1){
            int left = i+1;
            int right = nums.length-1;
            jump=-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);
                    int value1 = nums[left];
                    int value2 = nums[right];
                    while(left<right&&value1==nums[left]) ++left;
                    while(left<right&&value2==nums[right]) --right;
                }
                else if(nums[i]+nums[left]+nums[right]<0) ++left;
                else --right;
            }
            int value = nums[i];
            while(i<nums.length-1&&value==nums[i]) ++i;
        }
        return result;
    }
}