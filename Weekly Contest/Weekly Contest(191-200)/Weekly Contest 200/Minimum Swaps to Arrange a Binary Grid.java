class Solution {
    public int minSwaps(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[] count=new int[row];
        Arrays.fill(count, 0);
        
        for(int i=0; i<row; i++) {
            int t=0;
            for(int j=col-1; j>=0; j--) {
                if(grid[i][j]==1)
                    break;
                ++t;
            }
            count[i]=t;
        }
        
        int result=0;
        for(int i=0; i<row-1; i++) {
            if(count[i]>=col-1-i)
                continue;
            boolean unfind=true;
            for(int j=i+1; j<row; j++) {
                if(count[j]>=col-1-i) {
                    result+=j-i;
                    unfind=false;
                    for(int k=j; k>i; k--) {
                        int t=count[k];
                        count[k]=count[k-1];
                        count[k-1]=t;
                    }
                    break;
                }
            }
            if(unfind)
                return -1;
        }
        
        return result;
    }
}
