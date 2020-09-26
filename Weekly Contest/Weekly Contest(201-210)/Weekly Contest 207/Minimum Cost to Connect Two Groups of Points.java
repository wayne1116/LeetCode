// 1595. Minimum Cost to Connect Two Groups of Points
// difficulty: hard
// keypoint: dynamic programming, bit masking

class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int row=cost.size();
        int col=cost.get(0).size();
        int[][] graph=new int[row][col];
        Integer[][] dp=new Integer[row][1<<col];
        
        for(int i=0; i<row; i++) {
            List<Integer> temp=cost.get(i);
            for(int j=0; j<col; j++) {
                graph[i][j]=temp.get(j);
            }
        }
        
        int[] min=new int[col];
        for(int i=0; i<col; i++) {
            min[i]=graph[0][i];
            for(int j=1; j<row; j++)
                min[i]=Math.min(min[i], graph[j][i]);
        }
        
        return solv(0, 0, graph, min, dp);
    }
    
    int solv(int start, int mask, int[][] graph, int[] min, Integer[][] dp) {
        if(start>=graph.length) {
            int count=0;
            for(int i=0; i<graph[start-1].length; i++) {
                if((mask&(1<<i))==0)
                    count+=min[i];
            }
            return count;    
        }
        
        if(dp[start][mask]!=null)
            return dp[start][mask];
        
        int result=Integer.MAX_VALUE;
        for(int i=0; i<graph[start].length; i++)
            result=Math.min(result, graph[start][i]+solv(start+1, mask|(1<<i), graph, min, dp));
        dp[start][mask]=result;
        
        return result;
    }
}
