// 1641. Count Sorted Vowel Strings
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-213/problems/count-sorted-vowel-strings/
class Solution {
    public int countVowelStrings(int n) {
        int[][] dp=new int[n][5];
        for(int i=0; i<dp.length; i++)
            dp[i][0]=1;
        for(int i=0; i<5; i++)
            dp[0][i]=1;
        for(int i=1; i<n; i++) {
            for(int j=1; j<5; j++)
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
        }
        
        int result=0;
        for(int i=0; i<5; i++)
            result+=dp[n-1][i];
        
        return result;
    }
}
