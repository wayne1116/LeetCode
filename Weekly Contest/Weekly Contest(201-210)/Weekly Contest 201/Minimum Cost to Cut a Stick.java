class Solution {
    Integer[][] dp;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        dp=new Integer[cuts.length][cuts.length];
        return solv(0, n, cuts, 0, cuts.length-1);
    }
    
    int solv(int left, int right, int[] cuts, int l, int r) {
        if(l>r)
            return 0;
        if(l==r)
            return right-left;
        
        if(dp[l][r]!=null)
            return dp[l][r];
        
        for(int i=0; i<cuts.length; i++) {
            if(cuts[i]>left && cuts[i]<right) {
                if(dp[l][r]==null)
                    dp[l][r]=right-left+solv(left, cuts[i], cuts, l, i-1)+solv(cuts[i], right, cuts, i+1, r);
                else
                    dp[l][r]=Math.min(dp[l][r], right-left+solv(left, cuts[i], cuts, l, i-1)+solv(cuts[i], right, cuts, i+1, r));
            }
        }
        
        return dp[l][r];
    }
}
