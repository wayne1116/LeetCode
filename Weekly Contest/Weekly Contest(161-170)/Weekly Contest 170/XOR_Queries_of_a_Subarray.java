class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] dp = new int[arr.length+1];
        int[] result = new int[queries.length];
        dp[0]=0;
        for(int i=0; i<arr.length; i++) dp[i+1]=dp[i]^arr[i];
        for(int i=0; i<queries.length; i++){
            int s=queries[i][0];
            int e=queries[i][1];
            result[i]=dp[e+1]^dp[s];
        }
        return result;
    }
}
