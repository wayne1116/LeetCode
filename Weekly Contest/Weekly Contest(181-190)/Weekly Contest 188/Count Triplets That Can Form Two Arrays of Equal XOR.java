class Solution {
    public int countTriplets(int[] arr) {
        int[] dp=new int[arr.length+1];
        dp[0]=0;
        for(int i=0; i<arr.length; i++)
            dp[i+1]=dp[i]^arr[i];
        
        int result=0;
        for(int i=0; i<=arr.length; i++) {
            for(int j=i+2; j<=arr.length; j++) {
                if((dp[i]^dp[j])==0)
                    result+=j-i-1;
            }
        }
        
        return result;
    }
}
