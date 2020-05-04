class Solution {
    public int maxScore(String s) {
        int total1=0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='1')
                ++total1;
        }
        
        int result=0;
        int count0=0;
        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i)=='0')
                ++count0;
            else
                --total1;
            result=Math.max(result, total1+count0);
        }
        
        return result;
    }
}
