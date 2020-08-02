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
    Integer[][][][] dp;
    String line;
    int len;
    public int getLengthOfOptimalCompression(String s, int k) {
        len=s.length();
        line=s;
        dp=new Integer[101][k+1][26][101];
        return solv(0, k, 0, 0);
    }
    
    int solv(int currPosition, int remainDelete, int lastCharacter, int freq) {
        if(len<=currPosition)
            return 0;
        if(dp[currPosition][remainDelete][lastCharacter][freq]!=null)
            return dp[currPosition][remainDelete][lastCharacter][freq];
        
        int result=2147483647;
        int currCharacter=line.charAt(currPosition)-'a';
        // not delete current character
        if(remainDelete>=0) {
            if(currCharacter!=lastCharacter || freq==0)
                result=Math.min(result, 1+solv(currPosition+1, remainDelete, currCharacter, 1));
            else{
                int f=freq+1;
                int plus=0;
                if(f==2 || f==10 || f==100)
                    plus=1;
                result=Math.min(result, plus+solv(currPosition+1, remainDelete, currCharacter, f));
            }
        }
        // delete current character
        if(remainDelete>0)
            result=Math.min(result, solv(currPosition+1, remainDelete-1, lastCharacter, freq));
        
        dp[currPosition][remainDelete][lastCharacter][freq]=result;
        return result;
    }
}
