class Solution {
    
    public int numRollsToTarget(int d, int f, int target) {
        int[][] number = new int[32][1024];
        for(int i=0; i<32; i++){
            for(int j=0; j<1024; j++) number[i][j]=0;
        }
        for(int i=1; i<=f; i++) number[0][i]=1;
        for(int i=f+1; i<=target; i++) number[0][i]=0;
        
        for(int i=1; i<d; i++){
            for(int j=1; j<=target; j++){
                for(int k=1; k<=f; k++){
                    if(j-k>=1) number[i][j]=(number[i][j]+number[i-1][j-k])%1000000007;
                }
            }
        }
        return number[d-1][target];
    }
}
