class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left=0;
        Deque<Integer> max=new LinkedList<Integer>();
        Deque<Integer> min=new LinkedList<Integer>();
        int result=0;
        
        for(int i=0; i<nums.length; i++) {
            while(max.size()>0){
                if(max.peekLast()<nums[i])
                    max.pollLast();
                else break;
            }    
            max.addLast(nums[i]);
            
            while(min.size()>0) {
                if(min.peekLast()>nums[i])
                    min.pollLast();
                else break;
            }
            min.addLast(nums[i]);
            
            while(max.peek()-min.peek()>limit){
                if(max.peek()==nums[left])
                    max.poll();
                if(min.peek()==nums[left])
                    min.poll();
                ++left;
            }
            result=Math.max(result, i-left+1);
        }
        
        return result;
    }
}
