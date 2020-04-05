class Solution {
    public String stoneGameIII(int[] stoneValue) {
        Integer[][] dp=new Integer[stoneValue.length][2];
        int result=solv(0, 0, stoneValue, dp);
        
        if(result==0)
            return "Tie";
        return result>0?"Alice":"Bob";
    }
    
    int solv(int curr, int who, int[] stoneValue, Integer[][] dp) {
        if(curr>=stoneValue.length)
            return 0;
        
        if(dp[curr][who]!=null)
            return dp[curr][who];
        
        int score=0;
        int limit=Math.min(stoneValue.length, curr+3);
        int result=(who==0)?Integer.MIN_VALUE:Integer.MAX_VALUE;
        
        for(int i=curr; i<limit; i++){
            if(who==0){  // Alice
                score+=stoneValue[i];
                result=Math.max(result, score+solv(i+1, 1, stoneValue, dp));
            } else{     // Bob
                score-=stoneValue[i];
                result=Math.min(result, score+solv(i+1, 0, stoneValue, dp));
            }
        }
        
        dp[curr][who]=result;
        return dp[curr][who];
    }
}
