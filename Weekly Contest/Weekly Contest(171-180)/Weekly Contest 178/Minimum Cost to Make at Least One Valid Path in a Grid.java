class Solution {
    public int minCost(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][] visited=new int[row][col];
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int i=0; i<row; i++)
            Arrays.fill(visited[i], 1000000);
        
        Queue<int[]> queue=new LinkedList<int[]>();
        int[] temp=new int[2];
        int[] temp1;
        temp[0]=0;
        temp[1]=0;
        visited[0][0]=0;
        queue.offer(temp);
        
        while(queue.size()>0) {
            temp=queue.poll();
            for(int i=0; i<4; i++){
                if(temp[0]+dir[i][0]>=0 && temp[0]+dir[i][0]<row && temp[1]+dir[i][1]>=0 && temp[1]+dir[i][1]<col){
                    int r=temp[0]+dir[i][0];
                    int c=temp[1]+dir[i][1];
                    int cost=0;
                    if(i+1!=grid[temp[0]][temp[1]])
                        cost=1;
                    if(visited[r][c]>visited[temp[0]][temp[1]]+cost){
                        temp1=new int[2];
                        temp1[0]=r;
                        temp1[1]=c;
                        queue.offer(temp1);
                        visited[r][c]=visited[temp[0]][temp[1]]+cost;
                    }
                }
            }
        }
        
        return visited[row-1][col-1];
    }
}
