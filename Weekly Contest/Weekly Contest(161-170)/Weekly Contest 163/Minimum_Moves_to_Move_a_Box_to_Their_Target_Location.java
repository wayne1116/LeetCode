class Solution {
    boolean manbfs(int startr, int startc, int targetr, int targetc, int boxr, int boxc, char[][] grid){
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visited=new boolean[20][20];
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=0; i<20; i++) Arrays.fill(visited[i], false);
        queue.offer((startr<<5)|startc);
        visited[startr][startc]=true;
        
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        while(queue.size()>0){
            int value=queue.poll();
            int r=value>>5;
            int c=value&31;
            if(r==targetr && c==targetc) return true;
            for(int i=0; i<4; i++){
                int nextr=r+dir[i][0];
                int nextc=c+dir[i][1];
                if(nextr<0 || nextr>=row || nextc<0 || nextc>=col) continue;
                if(grid[nextr][nextc]!='.' || nextr==boxr && nextc==boxc) continue;
                if(!visited[nextr][nextc]){
                    queue.offer((nextr<<5)|nextc);
                    visited[nextr][nextc]=true;
                }
            }
        }
        return false;
    }
    
    public int minPushBox(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int manposr=0, manposc=0;
        int boxposr=0, boxposc=0;
        int tarposr=0, tarposc=0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]=='T'){
                    grid[i][j]='.';
                    tarposr=i;
                    tarposc=j;
                }
                else if(grid[i][j]=='S'){
                    grid[i][j]='.';
                    manposr=i;
                    manposc=j;
                }
                else if(grid[i][j]=='B'){
                    grid[i][j]='.';
                    boxposr=i;
                    boxposc=j;
                }
            }
        }
        
        // qbox: direction & boxposition
        Queue<Integer> qbox=new LinkedList<Integer>();
        // push right/left/up/down
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][][] visited=new boolean[4][20][20];
        for(int i=0; i<4; i++){
            for(int j=0; j<20; j++) Arrays.fill(visited[i][j], false);
        }
        
        for(int i=0; i<4; i++){
            int pushr=boxposr-dir[i][0];
            int pushc=boxposc-dir[i][1];
            if(pushr<0 || pushr>=row || pushc<0 || pushc>=col) continue;
            else if(grid[pushr][pushc]!='.') continue;
            if(manbfs(manposr, manposc, pushr, pushc, boxposr, boxposc, grid)){
                qbox.offer((i<<10)|(boxposr<<5)|boxposc);
                visited[i][boxposr][boxposc]=true;
            }
        }
        
        int step=1;
        while(qbox.size()>0){
            int len=qbox.size();
            while(len-->0){
                int value=qbox.poll();
                int boxd=value>>10;
                int boxr=(value>>5)&31;
                int boxc=value&31;
                manposr=boxr;
                manposc=boxc;
                int posr=boxr+dir[boxd][0];
                int posc=boxc+dir[boxd][1];
                if(posr<0 || posc<0 || posr>=row || posc>=col) continue;
                if(posr==tarposr && posc==tarposc) return step;
                if(grid[posr][posc]=='#') continue;
                for(int i=0; i<4; i++){
                    int pushr=posr-dir[i][0];
                    int pushc=posc-dir[i][1];
                    if(pushr<0 || pushr>=row || pushc<0 || pushc>=col) continue;
                    else if(grid[pushr][pushc]!='.') continue;
                    if(manbfs(manposr, manposc, pushr, pushc, posr, posc, grid) && !visited[i][posr][posc]){
                        qbox.offer((i<<10)|(posr<<5)|posc);
                        visited[i][posr][posc]=true;
                    }
                }
            }
            ++step;
        }
        return -1;
    }
}
