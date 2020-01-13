class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int[][][] result = new int[row][col][k+1];
        // initialize
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++) Arrays.fill(result[i][j], Integer.MAX_VALUE);
        }
        
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0,0,k});
        int[] temp;
        int r;
        int c;
        int ob;
        int dis;
        result[0][0][k]=0;
        while(queue.peek()!=null){
            temp = queue.poll();
            r = temp[0];
            c = temp[1];
            ob = temp[2];
            dis = result[r][c][ob];
            if(r==row-1 && c==col-1) return dis;
            for(int i=0; i<4; i++){
                int nextr = r + dir[i][0];
                int nextc = c + dir[i][1];
                int nob = ob;
                if(nextr>=0 && nextc>=0 && nextr<row && nextc<col){
                    if(grid[nextr][nextc]==1) 
                        --nob;
                    if(nob>=0 && dis+1<result[nextr][nextc][nob]){
                        result[nextr][nextc][nob] = dis+1;
                        queue.offer(new int[]{nextr, nextc, nob});
                    }
                }
            }
            
        }
        return -1;
    }
}
