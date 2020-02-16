class Solution {
    public int countNegatives(int[][] grid) {
        int result=0;
        for(int i=0; i<grid.length; i++) {
            int left=0;
            int right=grid[0].length-1;
            while(left<=right) {
                int middle=(left+right)>>1;
                if(grid[i][middle]>=0)
                    left=middle+1;
                else
                    right=middle-1;
            }
            result+=grid[0].length-left;
        }
        return result;
    }
}
