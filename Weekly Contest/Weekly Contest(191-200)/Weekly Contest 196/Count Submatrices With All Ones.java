class Solution {
    public int numSubmat(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int[][] dp=new int[row][col];
        
        for(int i=0; i<row; i++) {
            dp[i][0]=mat[i][0]==1?1:0;
            for(int j=1; j<col; j++) {
                if(mat[i][j]==0)
                    dp[i][j]=0;
                else
                    dp[i][j]=dp[i][j-1]+1;
            }
        }
        
        int result=0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                int min=dp[i][j];
                result+=dp[i][j];
                for(int k=i+1; k<row; k++) {
                    if(dp[k][j]==0)
                        break;
                    min=Math.min(min, dp[k][j]);
                    result+=min;
                }       
            }
        }
        
        return result;
    }
}
