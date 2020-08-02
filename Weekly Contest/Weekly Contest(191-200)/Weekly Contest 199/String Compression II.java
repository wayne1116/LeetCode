class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int[][] dp=new int[k+1][s.length()];
        int[] seq=new int[s.length()];
        List<Integer>[] location=new List[26];
        for(int i=0; i<26; i++)
            location[i]=new ArrayList<Integer>();
        for(int i=0; i<s.length(); i++) {
            int c=s.charAt(i)-'a';
            seq[i]=location[c].size();
            location[c].add(i);
        }
        
        // case: if not delete any character
        int count=0;
        int prevChar=-1;
        for(int i=0; i<s.length(); i++) {
            int c=s.charAt(i)-'a';
            if(c!=prevChar) {
                count=1;
                prevChar=c;
            }
            else ++count;
            
            if(i==0)
                dp[0][0]=1;
            else if(count<=2 || count==10 || count==100)
                dp[0][i]=dp[0][i-1]+1;
            else
                dp[0][i]=dp[0][i-1];
        }
        
        for(int i=1; i<=k; i++) {
            for(int j=i; j<s.length(); j++) {
                int result=dp[i-1][j-1]; // delete current character
                int c=s.charAt(j)-'a';
                for(int l=seq[j]; l>=0; l--) {
                    int delete=location[c].get(seq[j])-location[c].get(l)-(seq[j]-l);
                    count=seq[j]-l+1;
                    if(count>=100)
                        count=4;
                    else if(count>=10)
                        count=3;
                    else if(count>=2)
                        count=2;
                    else
                        count=1;
                    
                    if(delete<=i) {
                        if(location[c].get(l)==0)
                            result=Math.min(result, count);
                        else
                            result=Math.min(result, count+dp[i-delete][location[c].get(l)-1]);
                    }
                }
                dp[i][j]=result;
            }
        }
        
        return dp[k][s.length()-1];
    }
}

// another method reference: https://leetcode.com/problems/string-compression-ii/discuss/759416/JavaDP-Top-DownMemoizationExplained-and-Commented
class Solution {
    int len;
    String ss;
    Integer[][][][] dp;
    public int getLengthOfOptimalCompression(String s, int k) {
        len = s.length();
        ss = s;
        dp = new Integer[len][k+1][26][101];
        return dd(0,k,(int)'a'-'a',0);
    }
    private int dd(int pos, int k, int last, int freq){
        if(pos==len) return 0;
        int c = ss.charAt(pos)-'a';
        if(dp[pos][k][last][freq]!=null) return dp[pos][k][last][freq];
        int ans = Integer.MAX_VALUE;
		// Which means we can afford deleting
        if(k>=0){
            // start a new group
            if(c!=last || freq==0) ans = Math.min(ans,1+dd(pos+1,k,c,1));
            else {
                // continue the old group
                int nf = freq+1;
                if(nf==2 || nf ==10 || nf==100 || nf==1000) ans = Math.min(ans,1+dd(pos+1,k,c,nf)); 
                else ans = Math.min(ans,dd(pos+1,k,c,nf));
            }
        }
        if(k>0) ans = Math.min(ans,dd(pos+1,k-1,last,freq));
        return dp[pos][k][last][freq]=ans;
    }
}
