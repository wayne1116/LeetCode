class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int len=jobDifficulty.length;
        if(len<d) return -1;
        
        int Maxvalue=100000;
        int[][] intervalmax=new int[len][len];
        for(int i=0; i<len; i++){
            intervalmax[i][i]=jobDifficulty[i];
            for(int j=i+1; j<len; j++){
                intervalmax[i][j]=Math.max(intervalmax[i][j-1], jobDifficulty[j]);
            }
        }
        
        if(d==1) return intervalmax[0][len-1];
        
        int[][] dp=new int[d][len];
        // two partitions
        for(int i=1; i<len; i++){
            int val=Maxvalue;
            for(int j=1; j<=i; j++)
                val=Math.min(val, intervalmax[0][j-1]+intervalmax[j][i]);
            dp[1][i]=val;
        }
        
        // n partitions
        for(int part=2; part<d; part++){
            for(int i=part; i<len; i++){
                int val=Maxvalue;
                for(int j=part; j<=i; j++)
                    val=Math.min(val, dp[part-1][j-1]+intervalmax[j][i]);
                dp[part][i]=val;
            }
        }
        return dp[d-1][len-1];
    }
}
