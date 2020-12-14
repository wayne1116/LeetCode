// 1690. Stone Game VII
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-219/problems/stone-game-vii/

class Solution {
    Integer[][] dp;
    int solv(int left, int right, int[] stones, int turn, int total) {
        if(left>right)
            return 0;
        if(dp[left][right]!=null)
            return dp[left][right];
        
        if(turn == 1) {
            int result=solv(left+1, right, stones, 1-turn, total-stones[left])-(total-stones[left]);
            result = Math.min(result, solv(left, right-1, stones, 1-turn, total-stones[right])-(total-stones[right]));
            dp[left][right] = result;
        }
        else{
            int result=solv(left+1, right, stones, 1-turn, total-stones[left])+(total-stones[left]);
            result = Math.max(result, solv(left, right-1, stones, 1-turn, total-stones[right])+(total-stones[right]));
            dp[left][right] = result;
        }
        //System.out.println(left+" "+right+" "+turn+" "+dp[left][right][turn]);
        return dp[left][right];
    }
    public int stoneGameVII(int[] stones) {
        dp=new Integer[stones.length][stones.length];
        int total = 0;
        for(int i=0; i<stones.length; i++)
            total += stones[i];
        dp[0][stones.length-1] = solv(0, stones.length-1, stones, 0, total);
        return dp[0][stones.length-1];
    }
}
