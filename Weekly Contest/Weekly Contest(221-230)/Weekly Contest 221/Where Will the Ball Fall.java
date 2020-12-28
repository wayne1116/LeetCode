// 1706. Where Will the Ball Fall
// dfficulty: medium
// website: https://leetcode.com/contest/weekly-contest-221/problems/where-will-the-ball-fall/

class Solution {
    public int[] findBall(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] result = new int[col];
        for(int i=0; i<col; i++) {
            int r = 0;
            int c = i;
            while(r<row && c>=0 && c<col) {
                if(grid[r][c]==1) {
                    if(c+1<col && grid[r][c+1]==1)
                        c += 1;
                    else{
                        c = -1;
                        break;
                    }
                }
                else{
                    if(c-1>=0 && grid[r][c-1]==-1)
                        c -= 1;
                    else{
                        c = -1;
                        break;
                    }
                }
                ++r;
            }
            result[i] = c;
        }
        
        return result;
    }
}
