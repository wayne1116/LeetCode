class Solution {
    public int countServers(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[] rown=new int[row];
        int[] coln=new int[col];
        Arrays.fill(rown, 0);
        Arrays.fill(coln, 0);
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]==1){
                    ++rown[i];
                    ++coln[j];
                }
            }
        }
        
        int result=0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]==1 && (rown[i]>1 || coln[j]>1)) ++result;
            }
        }
        return result;
    }
}
