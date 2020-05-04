class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> dequeue=new LinkedList<Integer>();
        dequeue.add(nums[0]);
        int result=nums[0];
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        
        for(int i=1; i<nums.length; i++) {
            if(i>k && dp[i-k-1]==dequeue.peek())
                dequeue.pop();
            
            int value=Math.max(nums[i], dequeue.peek()+nums[i]);
            dp[i]=value;
            result=Math.max(result, dp[i]);
            while(dequeue.size()>0){
                if(dequeue.peekLast()>=value)
                    break;
                dequeue.pollLast();
            }
            dequeue.add(value);
        }
        return result;
    }
}
