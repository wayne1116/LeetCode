class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) matrix[i][j]=0;
        }
        
        for(int i=0; i<indices.length; i++){
            int row = indices[i][0];
            int col = indices[i][1];
            
            for(int j=0; j<m; j++) ++matrix[row][j];
            for(int j=0; j<n; j++) ++matrix[j][col];
        }
        
        int result=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) if(matrix[i][j]%2==1) ++result;
        }
        return result;
    }
}
