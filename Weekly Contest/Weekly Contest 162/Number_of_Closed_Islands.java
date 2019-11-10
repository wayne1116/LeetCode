class Solution {
    boolean[][] visit;
    int[][] dir;
    int[][] map;
    boolean bfs(int row, int col){
        Queue<Integer> qu1 = new LinkedList<Integer>();
        Queue<Integer> qu2 = new LinkedList<Integer>();
        qu1.offer(row);
        qu2.offer(col);
        
        int tempr;
        int tempc;
        boolean flag=true;
        while(qu1.peek()!=null){
            tempr=qu1.poll();
            tempc=qu2.poll();
            if(tempr==0 || tempc==0 || tempr==map.length-1 || tempc==map[0].length-1) flag=false;
            if(map[tempr][tempc]==0 && !visit[tempr][tempc]){
                visit[tempr][tempc]=true;
                for(int i=0; i<4; i++){
                    if(tempr+dir[i][0]>=0 && tempr+dir[i][0]<map.length && tempc+dir[i][1]>=0 && tempc+dir[i][1]<map[0].length){
                        if(!visit[tempr+dir[i][0]][tempc+dir[i][1]] && map[tempr+dir[i][0]][tempc+dir[i][1]]==0){
                            qu1.offer(tempr+dir[i][0]);
                            qu2.offer(tempc+dir[i][1]);
                        }
                    }
                }
            }
        }
        return flag;
    } 
    public int closedIsland(int[][] grid) {
        visit = new boolean[grid.length][grid[0].length];
        map = new int[grid.length][grid[0].length];
        dir = new int[4][2];
        
        dir[0][0]=-1; dir[0][1]=0;
        dir[1][0]=0; dir[1][1]=1;
        dir[2][0]=1; dir[2][1]=0;
        dir[3][0]=0; dir[3][1]=-1;
        
        int result=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                visit[i][j]=false;
                map[i][j]=grid[i][j];
            }
        }
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!visit[i][j] && grid[i][j]==0){
                    boolean flag=bfs(i,j);
                    if(flag) ++result;
                }        
            }
        }
        return result;
    }
}
