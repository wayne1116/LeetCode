class Solution {
    public int minFlips(String target) {
        int t=1;
        int result=0;
        for(int i=0; i<target.length(); i++) {
            char c=target.charAt(i);
            if(t==1 && c=='1' || t==0 && c=='0') {
                ++result;
                t=1-t;
            }
        }
        
        return result;
    }
}
