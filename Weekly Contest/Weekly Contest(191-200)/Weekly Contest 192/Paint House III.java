class Solution {
    int[][][] dp;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp=new int[m+1][target+1][n+1];
        /*for(int i=0; i<m; i++) {
            for(int j=0; j<=target; j++)
                Arrays.fill(dp[i][j], 0);
        }*/
        int result=solv(houses, cost, 0, target, 0);
        return result>=1000000?-1:result;
    }
    
    int solv(int[] houses, int[][] cost, int curr, int target, int last_label) {
        if(curr>=houses.length || target<0)
            return target==0?0:1000000;
        
        if(dp[curr][target][last_label]>0)
            return dp[curr][target][last_label];
        
        int diff;
        if(houses[curr]!=0){
            diff=(last_label==houses[curr]?0:1);    
            return solv(houses, cost, curr+1, target-diff, houses[curr]);
        }
        
        int result=1000000;
        for(int i=0; i<cost[curr].length; i++){
            int curr_label=i+1;
            diff=(last_label==curr_label?0:1);
            result=Math.min(result, cost[curr][i]+solv(houses, cost, curr+1, target-diff, curr_label));
        }     
        
        dp[curr][target][last_label]=result;
        return result;
    }
}
