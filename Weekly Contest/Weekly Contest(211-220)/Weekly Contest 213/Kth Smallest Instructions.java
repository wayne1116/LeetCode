// 1643. Kth Smallest Instructions
// difficulty: hard
// website: https://leetcode.com/contest/weekly-contest-213/problems/kth-smallest-instructions/

class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        int row=destination[0];
        int col=destination[1];
        int[][] dp=new int[row+1][col+1];
        
        int i=0, j=0;
        StringBuilder st=new StringBuilder();
        while(i<row && j<col) {
            for(int r=i; r<=row; r++)
                dp[r][j+1]=1;
            for(int c=j+1; c<=col; c++)
                dp[i][c]=1;
            for(int r=i+1; r<=row; r++) {
                for(int c=j+2; c<=col; c++)
                    dp[r][c]=dp[r-1][c]+dp[r][c-1];
            }
            if(k>dp[row][col]) {
                k-=dp[row][col];
                st.append("V");
                ++i;
            }
            else{
                st.append("H");
                ++j;
            }
        }
        
        while(i<row) {
            ++i;
            st.append("V");
        }
        while(j<col) {
            ++j;
            st.append("H");
        }
        
        return st.toString();
    }
}
