class Solution {
    int row;
    int col;
    int[] seatbit;
    int[][] dp;
    
    public int maxStudents(char[][] seats) {
        row=seats.length;
        col=seats[0].length;
        seatbit=new int[row];
        dp=new int[row][1<<col];
        
        for(int i=0; i<row; i++)
            Arrays.fill(dp[i], -1);
        
        for(int i=0; i<row; i++) {
            int bit=0;
            for(int j=0; j<col; j++){
                bit=(bit<<1);
                bit=bit|(seats[i][j]=='#'?1:0);
            }
            seatbit[i]=bit;
        }
        return solv(0, 0); // first: row ; second: state        
    }
    
    int solv(int r, int prevstate) {
        if(r==row)
            return 0;
        if(dp[r][prevstate]!=-1)
            return dp[r][prevstate];
        
        int limit=(1<<col);
        for(int i=0; i<limit; i++) {
            int haveleftseats=i&(i>>1);
            int haverightseats=i&(i<<1);
            int havetopleft=i&(prevstate>>1);
            int havetopright=i&(prevstate<<1);
            int canseat=i&seatbit[r];
            int result=haveleftseats | haverightseats | havetopleft | havetopright | canseat;
            if(result==0){
                int countbit=Integer.bitCount(i);
                dp[r][prevstate]=Math.max(dp[r][prevstate], countbit+solv(r+1, i));
            }
        }
        return Math.max(dp[r][prevstate], 0);
    }
}
