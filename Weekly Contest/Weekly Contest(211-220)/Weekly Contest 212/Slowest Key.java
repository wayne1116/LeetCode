// 1629. Slowest Key
// difficulty: easy
// website: https://leetcode.com/contest/weekly-contest-212/problems/slowest-key/

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] last=new int[26];
        last[keysPressed.charAt(0)-'a']=releaseTimes[0];
        for(int i=1; i<keysPressed.length(); i++) {
            int c=keysPressed.charAt(i)-'a';
            last[c]=Math.max(last[c], releaseTimes[i]-releaseTimes[i-1]);
        }
        
        int max=0;
        for(int i=25; i>=0; i--)
            max=Math.max(max, last[i]);
        
        for(int i=25; i>=0; i--)
            if(max==last[i])
                return (char)(i+'a');
        return 'a';
    }
}
