// 1688. Count of Matches in Tournament
// difficulty: easy
// website: https://leetcode.com/contest/weekly-contest-219/problems/count-of-matches-in-tournament/

class Solution {
    public int numberOfMatches(int n) {
        int result = 0;
        while(n>1) {
            result += n/2;
            if(n%2==1)
                n = n/2 + 1;
            else
                n = n / 2;
        }
        
        return result;
    }
}
