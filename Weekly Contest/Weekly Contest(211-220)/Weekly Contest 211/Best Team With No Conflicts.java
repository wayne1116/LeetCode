// 1626. Best Team With No Conflicts
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-211/problems/best-team-with-no-conflicts/

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] t=new int[scores.length][2];
        for(int i=0; i<scores.length; i++) {
            t[i][0]=ages[i];
            t[i][1]=scores[i];
        }
        
        Arrays.sort(t, new Comparator<int[]>(){
           public int compare(int[] a, int[] b) {
               if(a[0]==b[0])
                   return a[1]-b[1];
               return a[0]-b[0];
           } 
        });
        
        int[] dp=new int[scores.length];
        dp[0]=t[0][1];
        for(int i=1; i<t.length; i++) {
            // must choose this person
            int maxValue=t[i][1];
            for(int j=i-1; j>=0; j--) {
                if(t[j][1]<=t[i][1])
                    maxValue=Math.max(maxValue, t[i][1]+dp[j]);
            }
            
            dp[i]=maxValue;
        }
        
        int result=dp[0];
        for(int i=0; i<dp.length; i++)
            result=Math.max(result, dp[i]);
        return result;
    }
}
