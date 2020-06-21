class TreeAncestor {
    int maxPow;
    int[][] step;
    public TreeAncestor(int n, int[] parent) {
        maxPow=(int)(Math.log(n)/Math.log(2))+1;
        step=new int[maxPow][n];
        step[0]=parent;
        for(int i=1; i<maxPow; i++){
            for(int j=0; j<n; j++) {
                int up=step[i-1][j];
                if(up==-1)
                    step[i][j]=-1;
                else
                    step[i][j]=step[i-1][up];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int temp=maxPow-1;
        while(k>0 && node>=0){
            int s=1<<temp;
            if(k>=s){
                node=step[temp][node];
                k-=s;
            }
            else
                --temp;
        }
        
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
