// 1647. Minimum Deletions to Make Character Frequencies Unique
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-214/problems/minimum-deletions-to-make-character-frequencies-unique/

class Solution {
    public int minDeletions(String s) {
        int[] dp=new int[100001];
        int[] count=new int[26];
        for(int i=0; i<s.length(); i++)
            count[s.charAt(i)-'a']+=1;
        for(int i=0; i<26; i++)
            dp[count[i]]+=1;
        
        int result=0;
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=dp.length-1; i>0; i--) {
            if(dp[i]>1) {
                while(dp[i]>1) {
                    queue.offer(i);
                    dp[i]-=1;
                }
            }
            if(dp[i]==0 && queue.size()>0)
                result+=queue.poll()-i;
        }
        while(queue.size()>0)
            result+=queue.poll();
        
        return result;
    }
}
