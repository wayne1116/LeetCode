// 1563. Stone Game V
// difficulty: hard
// key point: dynamic programming
// website: https://leetcode.com/contest/weekly-contest-203/problems/stone-game-v/

class Solution {
    Integer[][] dp;
    public int stoneGameV(int[] stoneValue) {
        dp=new Integer[stoneValue.length][stoneValue.length];
        int[] presum=new int[stoneValue.length];
        presum[0]=stoneValue[0];
        for(int i=1; i<stoneValue.length; i++)
            presum[i]=presum[i-1]+stoneValue[i];
        
        return solv(presum, 0, stoneValue.length-1, 0);
    }
    
    int solv(int[] presum, int start, int end, int initValue) {
        if(start>=end)
            return 0;
        if(dp[start][end]!=null)
            return dp[start][end];
        
        int result=0;
        for(int i=start; i<=end; i++) {
            int part1=presum[i]-initValue;
            int part2=presum[end]-presum[i];
            int t=0;
            if(part1>part2)
                t=part2+solv(presum, i+1, end, presum[i]);
            else if(part1<part2)
                t=part1+solv(presum, start, i, initValue);
            else
                t=part1+Math.max(solv(presum, start, i, initValue), solv(presum, i+1, end, presum[i]));
            
            result=Math.max(result, t);
        }
        
        dp[start][end]=result;
        return result;
    }
}
