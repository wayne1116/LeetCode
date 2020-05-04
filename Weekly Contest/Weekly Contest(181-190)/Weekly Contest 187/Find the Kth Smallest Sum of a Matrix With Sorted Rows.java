class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int row=mat.length;
        int col=mat[0].length;
        int left=0;
        int right=5000*row;
        int result=0;
        
        while(left<=right) {
            int middle=(left+right)>>1;
            int count=solv(row, col, mat, middle, 0, 0, k);
            if(count>=k)
                right=middle-1;
            else
                left=middle+1;
        }
        
        return left;
    }
    
    int solv(int row, int col, int[][] mat, int targetsum, int r, int sum, int k){
        if(sum>targetsum)
            return 0;
        if(r==row)
            return 1;
        
        int result=0;
        for(int i=0; i<col; i++){
            int count=solv(row, col, mat, targetsum, r+1, sum+mat[r][i], k);
            if(count==0)
                break;
            result+=count;
            if(count>k)
                break;
        }
        return result;
    }
}
