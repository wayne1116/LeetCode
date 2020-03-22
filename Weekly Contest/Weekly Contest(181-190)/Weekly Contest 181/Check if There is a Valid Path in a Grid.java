class Solution {
    public boolean hasValidPath(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        Queue<int[]> queue=new LinkedList<int[]>();
        boolean[][] visited=new boolean[row][col];
        int[][] dir={{0},{0,1,0,-1},{-1,0,1,0},{0,-1,1,0},{1,0,0,1},{-1,0,0,-1},{-1,0,0,1}};
        int[][] valid={{0},{0},{1,3,5},{1,4,6},{2,3,4},{2,5,6},{1,4,6},{2,5,6},{2,5,6},{1,3,5},{2,3,4},{1,4,6},{2,3,4},{1,3,5}};
        
        for(int i=0; i<row; i++)
            Arrays.fill(visited[i], false);
            
        visited[0][0]=true;
        queue.offer(new int[]{0,0});
        while(queue.size()>0) {
            int[] temp=queue.poll();
            if(temp[0]==row-1 && temp[1]==col-1)
                return true;
            int token=grid[temp[0]][temp[1]];
            int x;
            int y;
            for(int i=0; i<2; i++) {
                x=temp[0]+dir[token][i*2];
                y=temp[1]+dir[token][i*2+1];
                if(x>=0 && x<row && y>=0 && y<col) {
                    if(!visited[x][y]) {
                        for(int j=0; j<valid[token*2+i].length; j++) {
                            if(valid[token*2+i][j]==grid[x][y]){
                                visited[x][y]=true;
                                queue.offer(new int[]{x,y});
                                break;
                            }
                        }
                    }
                }
            }
            
        }
        
        return false;
    }
}
