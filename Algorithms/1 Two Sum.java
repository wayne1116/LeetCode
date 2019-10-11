class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> temp = new HashMap<Integer,Integer>();
        int result1=0, result2=0;
        for(int i=0; i<nums.length; i++){
            if(temp.containsKey(target-nums[i])){
                result1=temp.get(target-nums[i]);
                result2=i;
                break;
            }
            else temp.put(nums[i],i);
        }
        return new int[]{result1,result2};
    }
}