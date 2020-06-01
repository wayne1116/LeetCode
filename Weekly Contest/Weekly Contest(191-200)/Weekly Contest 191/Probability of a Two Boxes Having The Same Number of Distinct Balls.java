class Solution {
    double[] dp;
    double result, total;
    public double getProbability(int[] balls) {
        int sum=0;
        for(int i=0; i<balls.length; i++)
           sum+=balls[i];
        sum=sum>>1;
        dp=new double[sum+1];
        dp[0]=1;
        for(int i=1; i<=sum; i++)
            dp[i]=dp[i-1]*i;
        
        int[] color=new int[balls.length];
        result=0;
        total=0;
        solv(balls, 0, 0, sum, color);
        
        return result/total;
    }
    
    void solv(int[] balls, int level, int sum, int target, int[] color) {
        if(level==balls.length){
            if(sum==target){
                int s=0;
                int diff1=0;
                int diff2=0;
                double total1=dp[target];
                double total2=dp[target];
                for(int i=0; i<balls.length; i++){
                    total1/=dp[balls[i]-color[i]];
                    total2/=dp[color[i]];
                    if(balls[i]-color[i]>0)
                        ++diff2;
                    if(color[i]>0)
                        ++diff1;
                    s+=color[i];
                }
                
                total+=total1*total2;
                if(diff1==diff2)
                    result+=total1*total2;
            }
            return;
        }
        
        for(int i=0; i<=balls[level]; i++){
            color[level]=i;
            solv(balls, level+1, sum+i, target, color);
        }
    }
}
