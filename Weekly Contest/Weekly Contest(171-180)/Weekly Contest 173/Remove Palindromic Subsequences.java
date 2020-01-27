class Solution {
    public int removePalindromeSub(String s) {
        if(s.length()==0) return 0;
        int limit=(s.length()-1)>>1;
        int len=s.length();
        boolean flag=false;
        for(int i=0; i<=limit; i++){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                flag=true;
                break;
            }
        }
        if(flag) return 2;
        return 1;
    }
}
