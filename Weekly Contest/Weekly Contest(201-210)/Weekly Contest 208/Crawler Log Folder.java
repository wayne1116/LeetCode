// 1598. Crawler Log Folder
// difficulty: easy
// website: https://leetcode.com/contest/weekly-contest-208/problems/crawler-log-folder/
class Solution {
    public int minOperations(String[] logs) {
        int count=0;
        for(int i=0; i<logs.length; i++) {
            String t=logs[i];
            if(t.equals("../"))
                count=Math.max(0, count-1);
            else if(t.equals("./"))
                continue;
            else
                ++count;
        }
        
        return count;
    }
}
