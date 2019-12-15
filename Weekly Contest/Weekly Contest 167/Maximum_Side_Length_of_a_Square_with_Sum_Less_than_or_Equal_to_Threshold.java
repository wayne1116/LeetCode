class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int[][] row = new int[mat.length][mat[0].length];
        int[][] col = new int[mat.length][mat[0].length];
        
        for(int i=0; i<mat.length; i++){
            col[i][0] = mat[i][0];
            for(int j=1; j<mat[0].length; j++) col[i][j] = col[i][j-1] + mat[i][j];
        }
        
        for(int j=0; j<mat[0].length; j++){
            row[0][j] = mat[0][j];
            for(int i=1; i<mat.length; i++) row[i][j] = row[i-1][j] + mat[i][j];
        }
        
        int result = 0;
        int startrow = 0;
        int startcol = 0;
        long tempsum = 0;
        int index = 0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                startrow=i;
                startcol=j;
                tempsum=0;
                index = 1;
                while(startrow<mat.length&&startcol<mat[0].length){
                    if(index>1){
                        if(startrow-index>=0 && startcol-index>=0) 
                            tempsum = tempsum+row[startrow][startcol]-row[startrow-index][startcol]+col[startrow][startcol]-col[startrow][startcol-index]-mat[startrow][startcol];
                        else 
                            tempsum = tempsum+row[startrow][startcol]+col[startrow][startcol]-mat[startrow][startcol];
                    }
                    else tempsum = mat[startrow][startcol];
                    if(threshold>=tempsum) result = Math.max(result, index);
                    else break;
                    ++startrow;
                    ++startcol;
                    ++index;
                }
            }
        }
        return result;
    }
}
