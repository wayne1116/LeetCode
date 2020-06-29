class Solution {
    public int numSubseq(int[] nums, int target) {
        int[] mod=new int[100001];
        mod[0]=1;
        mod[1]=2;
        for(int i=2; i<100001; i++)
            mod[i]=(mod[i-1]*2)%1000000007;
        
        Arrays.sort(nums);
        int result=0;
        for(int i=0; i<nums.length; i++) {
            if(target<=nums[i])
                break;
            int remain=target-nums[i];
            if(remain<nums[i])
                break;
            
            int left=i;
            int right=nums.length-1;
            while(left<=right) {
                int middle=(left+right)>>1;
                if(nums[middle]>remain)
                    right=middle-1;
                else
                    left=middle+1;
            }
            result=(result+mod[left-i-1])%1000000007;
        }
        
        return result;
    }
}
