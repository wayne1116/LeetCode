class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result=new ArrayList<Integer>();
        if(matrix.length==0)
            return result;
        
        int row=matrix.length;
        int col=matrix[0].length;
        int[] rowmin=new int[row];
        int[] colmin=new int[col];
        
        for(int i=0; i<row; i++) {
            rowmin[i]=matrix[i][0];
            for(int j=1; j<col; j++)
                rowmin[i]=Math.min(rowmin[i], matrix[i][j]);
        }
        
        for(int j=0; j<col; j++) {
            colmin[j]=matrix[0][j];
            for(int i=1; i<row; i++) 
                colmin[j]=Math.max(colmin[j], matrix[i][j]);
        }
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++)
                if(rowmin[i]==colmin[j])
                    result.add(rowmin[i]);
        }
        
        return result;
    }
}
