class MyCompare implements Comparator<Solution>{
    public int compare(Solution a, Solution b){
        if(a.start==b.start) return a.end-b.end;
        return a.start-b.start;
    }
}
class Solution {
    int start;
    int end;
    public int minTaps(int n, int[] ranges) {
        Solution[] lnode=new Solution[ranges.length];
        for(int i=0; i<ranges.length; i++){
            lnode[i]=new Solution();
            lnode[i].start=Math.max(i-ranges[i], 0);
            lnode[i].end=Math.min(i+ranges[i], n);
        }     
        Arrays.sort(lnode, new MyCompare());
        
        int MaxValue=10000000;
        int result=MaxValue;
        int[] dp=new int[ranges.length];
        Arrays.fill(dp, MaxValue);
        
        for(int i=n; i>=0; i--){
            if(lnode[i].end==n) dp[i]=1;
            
            for(int j=i+1; j<=n; j++){
                int s=lnode[j].start;
                int e=lnode[j].end;
                if(lnode[i].end>=s) dp[i]=Math.min(dp[i], dp[j]+1);
            }
            if(lnode[i].start==0) result=Math.min(result, dp[i]);
        }
        
        return result==MaxValue?-1:result;
    }
}
