class Solution {
    int calccost(int left, int right, String s){
        int cost=0;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) ++cost;
            ++left;
            --right;
        }
        return cost;
    }
    public int palindromePartition(String s, int k) {
        int[][] cost=new int[s.length()][s.length()];
        int Maxvalue=10000000;
        
        // calculate the cost of the string from i to j
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++) cost[i][j]=calccost(i, j, s);
        }
        // when k=1 (not need to divide)
        if(k==1) return cost[0][s.length()-1];
        
        
        int[][] dp=new int[k][s.length()];
        // two partitions
        for(int i=1; i<s.length(); i++){
            int value=Maxvalue;
            for(int j=1; j<=i; j++)
                value=Math.min(value, cost[0][j-1]+cost[j][i]);
            dp[1][i]=value;
        }
        
        // part: n partitions
        for(int part=2; part<k; part++){
            // i: the index of the string
            for(int i=part; i<s.length(); i++){
                int value=Maxvalue;
                // j: the place where the partition happens
                for(int j=part; j<=i; j++)
                    value=Math.min(value, dp[part-1][j-1]+cost[j][i]);
                dp[part][i]=value;
            }
        }
        return dp[k-1][s.length()-1];
    }
}
