class Solution {
    public int numSub(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp, 0);
        
        int result=0;
        if(s.charAt(0)=='1')
            dp[0]=1;
        result+=dp[0];
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i)=='1') {
                dp[i]=dp[i-1]+1;
            }
            result=(result+dp[i])%1000000007;
        }
        
        return result;
    }
}
