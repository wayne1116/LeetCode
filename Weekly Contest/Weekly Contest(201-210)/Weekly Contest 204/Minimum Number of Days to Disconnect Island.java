// 1568. Minimum Number of Days to Disconnect Island
// difficulty: medium
// key point: dfs, connected component
// website: https://leetcode.com/contest/weekly-contest-204/problems/minimum-number-of-days-to-disconnect-island/
class Solution {
    public int minDays(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        if(row==1 && col==1 && grid[0][0]==1)
            return 1;
        if(row==1 && col==2 && grid[0][0]==1 && grid[0][1]==1)
            return 2;
        
        Queue<Integer> queue=new LinkedList<Integer>();
        Queue<Integer> connected=new LinkedList<Integer>();
        boolean[][] visited=new boolean[row][col];
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        int count=0, total=0, island=0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j]==1)
                    ++total;
                if(!visited[i][j] && grid[i][j]==1) {
                    ++island;
                    visited[i][j]=true;
                    queue.offer(i*col+j);
                    while(queue.size()>0) {
                        int t=queue.poll();
                        int x=t/col;
                        int y=t%col;
                        int c=0;
                        for(int k=0; k<4; k++) {
                            int nx=x+dir[k][0];
                            int ny=y+dir[k][1];
                            if(nx>=0 && nx<row && ny>=0 && ny<col && grid[nx][ny]==1) {
                                ++c;
                                if(!visited[nx][ny]) {
                                    visited[nx][ny]=true;
                                    queue.offer(nx*col+ny);
                                }
                            }
                        }
                        if(c==1)
                            ++count;
                        else if(c==2) {
                            if(x-1>=0 && x+1<row && grid[x-1][y]==1 && grid[x+1][y]==1 || y-1>=0 && y+1<col && grid[x][y-1]==1 && grid[x][y+1]==1)
                                connected.offer(x*col+y);
                        }
                    }
                }
            }
        }
        
        if(island==0 || island>=2)
            return 0;
        if(count==total)
            return 2;
        if(count>0)
            return 1;

        while(connected.size()>0) {
            for(int i=0; i<row; i++)
                Arrays.fill(visited[i], false);
            int t=connected.poll();
            int x=t/col;
            int y=t%col;
            visited[x][y]=true;
            int temp=total-1;
            for(int i=0; i<4; i++) {
                int nx=x+dir[i][0];
                int ny=y+dir[i][1];
                if(nx>=0 && nx<row && ny>=0 && ny<col && grid[nx][ny]==1) {
                    queue.offer(nx*col+ny);
                    break;
                }
            }
            while(queue.size()>0) {
                t=queue.poll();
                x=t/col;
                y=t%col;
                for(int k=0; k<4; k++) {
                    int nx=x+dir[k][0];
                    int ny=y+dir[k][1];
                    if(nx>=0 && nx<row && ny>=0 && ny<col && grid[nx][ny]==1 && !visited[nx][ny]) {
                        visited[nx][ny]=true;
                        queue.offer(nx*col+ny);
                        --temp;
                    }
                }
            }
            if(temp>0)
                return 1;
        }
        
        return 2;
    }
}
