class Solution {
    public int ways(String[] pizza, int k) {
        if(pizza.length==0 || k<=0) return 0;
        int row=pizza.length;
        int col=pizza[0].length();
        int[][] subapplecount=new int[row+1][col+1];
        
        /*subapplecount[row-1][col-1]=pizza[row-1].charAt(col-1)=='A'?1:0;
        for(int i=row-2; i>=0; i--) {
            subapplecount[i][col-1]=subapplecount[i+1][col-1]+(pizza[i].charAt(col-1)=='A'?1:0);
        }
        for(int j=col-2; j>=0; j--) {
            subapplecount[row-1][j]=subapplecount[row-1][j+1]+(pizza[row-1].charAt(j)=='A'?1:0);
        }*/
        
        for(int i=row-1; i>=0; i--) {
            for(int j=col-1; j>=0; j--){
                subapplecount[i][j]=subapplecount[i+1][j]+subapplecount[i][j+1]-subapplecount[i+1][j+1];
                subapplecount[i][j]+=(pizza[i].charAt(j)=='A'?1:0);
            }
        }
        
        Integer[][][] dp=new Integer[row][col][k];
        return solv(0, 0, k-1, dp, subapplecount, row, col);
    }
    
    int solv(int sx, int sy, int k, Integer[][][] dp, int[][] subapplecount, int row, int col) {
        if(sx>=row || sy>=col || k<0)
            return 0;
        if(k==0)
            return subapplecount[sx][sy]>0?1:0;
        if(dp[sx][sy][k]!=null)
            return dp[sx][sy][k];
        
        long result=0;
        for(int i=sx; i<row; i++) {
            if(subapplecount[sx][sy]-subapplecount[i+1][sy]>0)
                result+=solv(i+1, sy, k-1, dp, subapplecount, row, col);
        }
        
        for(int j=sy; j<col; j++) {
            if(subapplecount[sx][sy]-subapplecount[sx][j+1]>0)
                result+=solv(sx, j+1, k-1, dp, subapplecount, row, col);
        }
        
        dp[sx][sy][k]=(int)(result%1000000007);
        return dp[sx][sy][k];
    }
}
