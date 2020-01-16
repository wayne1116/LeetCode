class Solution {
    int solv(int state, int i, int j, int row, int col, int[] hashvalue){
        if(i+1<row) state^=hashvalue[(i+1)*col+j];
        if(i-1>=0) state^=hashvalue[(i-1)*col+j];
        if(j+1<col) state^=hashvalue[i*col+j+1];
        if(j-1>=0) state^=hashvalue[i*col+j-1];
        state^=hashvalue[i*col+j];
        return state;
    }
    public int minFlips(int[][] mat) {
        Queue<Integer> queue=new LinkedList<Integer>();
        int row=mat.length;
        int col=mat[0].length;
        int total=row*col;
        int[] hashvalue=new int[total];
        boolean[] flag=new boolean[1024];
        hashvalue[0]=1;
        for(int i=1; i<total; i++) hashvalue[i]=hashvalue[i-1]<<1;
        
        int state=0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(mat[i][j]==1) state|=hashvalue[i*col+j];
            }
        }
        if(state==0) return 0;
        
        int step=0;
        queue.offer(state);
        Arrays.fill(flag, true);
        int result=-1;
        flag[state]=false;
        while(queue.size()>0){
            int len=queue.size();
            //System.out.println("----"+step+"----");
            while(len-->0){
                state=queue.poll();
                //System.out.println(state);
                if(state==0){
                    result=step;
                    break;
                }
                for(int i=0; i<row; i++){
                    for(int j=0; j<col; j++){
                        int newstate=solv(state, i, j, row, col, hashvalue);
                        if(flag[newstate]) queue.offer(newstate);
                        flag[newstate]=false;
                    }
                }
            }
            if(state==0) break;
            ++step;
        }
        return result;
    }
}
