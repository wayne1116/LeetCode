// 1615. Maximal Network Rank
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-210/problems/maximal-network-rank/

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] roadCount=new int[n];
        boolean[] flag=new boolean[(n+1)*n];
        for(int i=0; i<roads.length; i++) {
            roadCount[roads[i][0]]+=1;
            roadCount[roads[i][1]]+=1;
            flag[roads[i][0]*n+roads[i][1]]=true;
            flag[roads[i][1]*n+roads[i][0]]=true;
        }
        
        int result=0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int plus=flag[i*n+j]?1:0;
                result=Math.max(result, roadCount[i]+roadCount[j]-plus);
            }
        }
        
        return result;
    }
}
