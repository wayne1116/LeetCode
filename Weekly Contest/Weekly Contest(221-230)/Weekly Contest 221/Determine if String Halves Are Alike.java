// 1704. Determine if String Halves Are Alike
// difficulty: easy
// website: https://leetcode.com/contest/weekly-contest-221/problems/determine-if-string-halves-are-alike/

class Solution {
    char lowercase(char c) {
        if(c>='A' && c<='Z')
            return (char)(c-'A'+'a');
        return c;
    }
    public boolean halvesAreAlike(String s) {
        int count1=0, count2=0;
        for(int i=0; i<s.length()/2; i++) {
            char c = s.charAt(i);
            c = lowercase(c);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
                count1++;
        }
        
        for(int i=s.length()/2; i<s.length(); i++) {
            char c = s.charAt(i);
            c = lowercase(c);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
                count2++;
        }
        
        return count1==count2;
    }
}
