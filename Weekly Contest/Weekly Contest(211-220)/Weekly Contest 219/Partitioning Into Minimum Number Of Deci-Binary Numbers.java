// 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-219/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

class Solution {
    public int minPartitions(String n) {
        int result = 0;
        for(int i=0; i<n.length(); i++) {
            int c = n.charAt(i)-'0';
            result = Math.max(result, c);
        }
        
        return result;
    }
}
