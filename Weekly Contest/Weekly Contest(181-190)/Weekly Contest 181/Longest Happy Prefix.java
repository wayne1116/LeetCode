class Solution {
    public String longestPrefix(String s) {
        if(s.length()<=1)
            return "";
            
        // KMP Failure Function
        int[] line=new int[s.length()];
        for(int i=0; i<s.length(); i++)
            line[i]=s.charAt(i);
        
        int[] dp=new int[s.length()];
        Arrays.fill(dp, -1);
        
        for(int i=1; i<s.length(); i++) {
            int j=dp[i-1];
            while(line[i]!=line[j+1] && j>=0)
                j=dp[j];
            
            if(line[i]==line[j+1])
                dp[i]=j+1;
        }
        
        return s.substring(0, dp[s.length()-1]+1); 
    }
}
