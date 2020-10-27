// 1631. Path With Minimum Effort
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-212/problems/path-with-minimum-effort/

class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        
        int row=heights.length;
        int col=heights[0].length;
        int result=0;
        boolean[][] flag=new boolean[row][col];
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        pq.offer(new int[]{0, 0});
        
        while(pq.size()>0) {
            int[] t=pq.poll();
            if(t[1]==(row-1)*col+col-1) {
                result=t[0];
                break;
            }
            int r=t[1]/col;
            int c=t[1]%col;
            flag[r][c]=true;
            for(int i=0; i<4; i++) {
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];
                if(nr>=0 && nr<row && nc>=0 && nc<col && !flag[nr][nc])
                    pq.offer(new int[]{Math.max(t[0], Math.abs(heights[r][c]-heights[nr][nc])), nr*col+nc});
            } 
        }
        return result;
    }
    
}
