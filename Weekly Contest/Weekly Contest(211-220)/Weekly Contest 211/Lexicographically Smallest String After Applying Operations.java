// 1625. Lexicographically Smallest String After Applying Operations
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-211/problems/lexicographically-smallest-string-after-applying-operations/
// keypoint: dfs, set(record the states) 

class Solution {
    String result;
    void dfs(String s, int a, int b, Set<String> set) {
        if(set.contains(s))
            return;
    
        set.add(s);
        if(result.compareTo(s)>0)
            result=s;
        
        String second=s.substring(0, s.length()-b);
        String first=s.substring(s.length()-b);
        String r=first+second;
        dfs(r, a, b, set);
        
        char[] c=r.toCharArray();
        for(int i=1; i<r.length(); i+=2)
            c[i]=(char)(((c[i]-'0'+a)%10)+'0');
        
        dfs(new String(c), a, b, set);
    }
    
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> set=new HashSet<String>();
        result=s;
        dfs(s, a, b, set);
        
        return result;
    }
}
