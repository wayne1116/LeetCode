// 1594. Maximum Non Negative Product in a Matrix
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-207/problems/maximum-non-negative-product-in-a-matrix/

class Solution {
    public int maxProductPath(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        long[][][] graph=new long[row][col][2];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                graph[i][j][0]=-1;
                graph[i][j][1]=1;
            }
        }
        if(grid[0][0]>=0)
            graph[0][0][0]=grid[0][0];
        if(grid[0][0]<=0)
            graph[0][0][1]=grid[0][0];
        
        for(int i=1; i<row; i++) {
            if(graph[i-1][0][0]>=0) {
                graph[i][0][0]=Math.max(graph[i][0][0], graph[i-1][0][0]*grid[i][0]);
                graph[i][0][1]=Math.min(graph[i][0][1], graph[i-1][0][0]*grid[i][0]);
            }
            if(graph[i-1][0][1]<=0) {
                graph[i][0][0]=Math.max(graph[i][0][0], graph[i-1][0][1]*grid[i][0]);
                graph[i][0][1]=Math.min(graph[i][0][1], graph[i-1][0][1]*grid[i][0]);
            }
        }
        
        for(int i=1; i<col; i++) {
            if(graph[0][i-1][0]>=0) {
                graph[0][i][0]=Math.max(graph[0][i][0], graph[0][i-1][0]*grid[0][i]);
                graph[0][i][1]=Math.min(graph[0][i][1], graph[0][i-1][0]*grid[0][i]);
            }
            if(graph[0][i-1][1]<=0) {
                graph[0][i][0]=Math.max(graph[0][i][0], graph[0][i-1][1]*grid[0][i]);
                graph[0][i][1]=Math.min(graph[0][i][1], graph[0][i-1][1]*grid[0][i]);
            }
        }
        
        int[][] dir={{-1,0},{0,-1}};
        for(int i=1; i<row; i++) {
            for(int j=1; j<col; j++) {
                for(int k=0; k<dir.length; k++) {
                    int x=i+dir[k][0];
                    int y=j+dir[k][1];
                    if(graph[x][y][0]>=0) {
                        graph[i][j][0]=Math.max(graph[i][j][0], graph[x][y][0]*grid[i][j]);
                        graph[i][j][1]=Math.min(graph[i][j][1], graph[x][y][0]*grid[i][j]);
                    }
                    if(graph[x][y][1]<=0) {
                        graph[i][j][0]=Math.max(graph[i][j][0], graph[x][y][1]*grid[i][j]);
                        graph[i][j][1]=Math.min(graph[i][j][1], graph[x][y][1]*grid[i][j]);
                    }
                }
            }
        }
        
        if(graph[row-1][col-1][0]<=graph[row-1][col-1][1] && graph[row-1][col-1][1]==0)
            return 0;
        
        return (int)(graph[row-1][col-1][0]%1000000007);
    }
}
