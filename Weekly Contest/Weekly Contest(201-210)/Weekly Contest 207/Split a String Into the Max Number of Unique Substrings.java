// 1593. Split a String Into the Max Number of Unique Substrings
// difficulty: medium
// https://leetcode.com/contest/weekly-contest-207/problems/split-a-string-into-the-max-number-of-unique-substrings/

class Solution {
    int result;
    public int maxUniqueSplit(String s) {
        result=0;
        solv(s, 0, new HashSet<Integer>(), 0);
        return result;
    }
    
    void solv(String s, int start, Set<Integer> set, int count) {
        if(s.length()<=start) {
            result=Math.max(result, count);
            return;
        }
        
        int value=0;
        for(int i=start; i<s.length(); i++) {
            int c=s.charAt(i)-'a'+1;
            value=value*27+c;
            if(!set.contains(value)) {
                set.add(value);
                solv(s, i+1, set, count+1);
                set.remove(value);
            }
        }
    }
}
