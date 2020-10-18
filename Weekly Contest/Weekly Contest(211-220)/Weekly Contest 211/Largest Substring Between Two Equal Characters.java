// 1624. Largest Substring Between Two Equal Characters
// difficulty: easy
// website: https://leetcode.com/contest/weekly-contest-211/problems/largest-substring-between-two-equal-characters/

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] count=new int[26];
        Arrays.fill(count, -1);
        int result=-1;
        
        for(int i=0; i<s.length(); i++) {
            int c=s.charAt(i)-'a';
            if(count[c]>=0)
                result=Math.max(result, i-count[c]-1);
            else
                count[c]=i;
        }
        
        return result;
    }
}
