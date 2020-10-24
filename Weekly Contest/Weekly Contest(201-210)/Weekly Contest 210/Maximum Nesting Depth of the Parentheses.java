// 1614. Maximum Nesting Depth of the Parentheses
// difficulty: easy
// website: https://leetcode.com/contest/weekly-contest-210/problems/maximum-nesting-depth-of-the-parentheses/

class Solution {
    public int maxDepth(String s) {
        int lCount=0;
        int result=0;
        for(int i=0; i<s.length(); i++) {
            char c=s.charAt(i);
            if(c=='(')
                ++lCount;
            else if(c==')') {
                result=Math.max(lCount, result);
                lCount-=1;
            }
        }
        
        return result;
    }
}
