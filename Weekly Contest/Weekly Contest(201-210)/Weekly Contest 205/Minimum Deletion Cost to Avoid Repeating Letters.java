// 1578. Minimum Deletion Cost to Avoid Repeating Letters
// difficulty: medium
// keypoint: greedy
// website: https://leetcode.com/contest/weekly-contest-205/problems/minimum-deletion-cost-to-avoid-repeating-letters/

class Solution {
    public int minCost(String s, int[] cost) {
        int prev=-1;
        int total=0;
        int maxValue=0;
        int result=0;
        for(int i=0; i<s.length(); i++) {
            int curr=s.charAt(i);
            if(prev!=curr) {
                result+=total-maxValue;
                prev=curr;
                maxValue=cost[i];
                total=cost[i];
            }
            else{
                total+=cost[i];
                maxValue=Math.max(maxValue, cost[i]);
            }
        }
        result+=total-maxValue;
        
        return result;
    }
}
