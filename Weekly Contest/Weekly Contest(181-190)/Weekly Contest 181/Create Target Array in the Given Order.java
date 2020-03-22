class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> temp=new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++)
            temp.add(index[i], nums[i]);
        
        int[] result=new int[nums.length];
        for(int i=0; i<nums.length; i++)
            result[i]=temp.get(i);
        
        return result;
    }
}
