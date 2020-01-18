class Solution {
    public int countSquares(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int square=Math.min(row, col);
        int[][] dp=new int[row][col];
        for(int i=0; i<row; i++) dp[i][0]=matrix[i][0];
        for(int i=0; i<row; i++){
            for(int j=1; j<col; j++) dp[i][j]=dp[i][j-1]+matrix[i][j];
        }
        
        int result=0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                result+=matrix[i][j];
                for(int k=2; k<=square; k++){
                    if(i+k<=row && j+k<=col){
                        int sum=0;
                        for(int l=i; l<i+k; l++) sum+=dp[l][j+k-1]-dp[l][j]+matrix[l][j];
                        if(sum!=k*k) break;
                        ++result;
                    }
                    else break;
                }
            }
        }
        return result;
    }
}
