class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        List<int[]> possible=new ArrayList<int[]>();
        int sum=0;
        map.put(sum, -1);
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            int diff=sum-target;
            if(map.containsKey(diff)) 
                possible.add(new int[]{map.get(diff)+1, i+1});
            map.put(sum, i+1);
        }
        if(possible.size()==0)
            return 0;
        
        int result=1;
        int start=possible.get(0)[0];
        int end=possible.get(0)[1];
        for(int i=1; i<possible.size(); i++) {
            int[] t=possible.get(i);
            if(end<t[0]) {
                ++result;
                end=t[1];
            }
        }
        
        return result;
    }
}
