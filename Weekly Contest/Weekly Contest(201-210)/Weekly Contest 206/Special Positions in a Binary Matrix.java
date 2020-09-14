// 1582. Special Positions in a Binary Matrix
// difficulty: easy

class Solution {
    public int numSpecial(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int result=0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(mat[i][j]==1) {
                    int count=0;;
                    for(int k=j+1; k<col; k++) {
                        if(mat[i][k]==1)
                            ++count;
                    }
                    if(count==0) {
                        count=0;
                        for(int k=0; k<row; k++) {
                            if(mat[k][j]==1)
                                ++count;
                        }
                        if(count==1)
                            ++result;
                    }
                    break;
                }
            }
        } 
        
        return result;
    }
}
