// 1696. Jump Game VI
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-220/problems/jump-game-vi/

class Solution {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return b[1]-a[1];
            }
        });
        
        int result = nums[0];
        pq.offer(new int[]{0, nums[0]});
        for(int i=1; i<nums.length; i++) {
            while(pq.size()>0) {
                if(pq.peek()[0]+k>=i)
                    break;
                pq.poll();
            }    
            if(i==nums.length-1)
                result = pq.peek()[1]+nums[i];
            pq.offer(new int[]{i, pq.peek()[1]+nums[i]});
        }
        
        return result;
        
    }
}
