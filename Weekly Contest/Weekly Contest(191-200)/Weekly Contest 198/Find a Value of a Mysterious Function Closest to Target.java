class Solution {
    public int closestToTarget(int[] arr, int target) {
        int[][] dp=new int[arr.length][32];
        for(int i=0; i<arr.length; i++)
            Arrays.fill(dp[i], 0);
        
        int result=Math.abs(arr[0]-target);
        int t=arr[0];
        for(int i=0; i<32; i++) {
            dp[0][i]=t&1;
            t>>=1;
        }
        
        for(int i=1; i<arr.length; i++) {
            t=arr[i];
            result=Math.min(result, Math.abs(arr[i]-target));
            for(int j=0; j<32; j++) {
                dp[i][j]=dp[i-1][j]+(t&1);
                t>>=1;
            }
        }
        
        int left, right;
        for(int i=0; i<arr.length; i++) {
            left=0;
            right=i-1;
            while(left<=right) {
                int middle=(left+right)>>1;
                int v=0;
                for(int j=0; j<32; j++) {
                    int n=dp[i][j]-dp[middle][j];
                    if(n==i-middle)
                        v|=(1<<j);
                }
                t=arr[middle]&v;
                result=Math.min(result, Math.abs(t-target));
                if(t-target<0)
                    left=middle+1;
                else
                    right=middle-1;
            }
        }
        
        return result;
    }
}
