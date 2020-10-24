// 1616. Split Two Strings to Make Palindrome
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-210/problems/split-two-strings-to-make-palindrome/

class Solution {
    boolean check(String word) {
        int i=0;
        int j=word.length()-1;
        while(i<j) {
            char c1=word.charAt(i);
            char c2=word.charAt(j);
            if(c1!=c2)
                return false;
            ++i;
            --j;
        }
        return true;
    }
    boolean check(String a, String b) {
        int i=0;
        int j=b.length()-1;
        while(i<j) {
            char c1=a.charAt(i);
            char c2=b.charAt(j);
            if(c1!=c2)
                break;
            i++;
            j--;
        }
        
        int t1=i;
        int t2=j;
        while(t1<t2) {
            char c1=b.charAt(t1);
            char c2=b.charAt(t2);
            if(c1!=c2)
                break;
            ++t1;
            --t2;
        }
        if(t1>=t2)
            return true;
        
        while(i<j) {
            char c1=a.charAt(i);
            char c2=a.charAt(j);
            if(c1!=c2)
                break;
            ++i;
            --j;
        }
        
        if(i>=j)
            return true;
        return false;
    }
    public boolean checkPalindromeFormation(String a, String b) {
        boolean ispalin=check(a);
        if(ispalin)
            return true;
        ispalin=check(b);
        if(ispalin)
            return true;
        
        ispalin=check(a, b);
        if(ispalin)
            return true;
        
        return check(b, a);
    }
}
