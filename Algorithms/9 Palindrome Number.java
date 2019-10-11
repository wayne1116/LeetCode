class Solution {
    public boolean isPalindrome(int x) {
        if(x<10 && x>=0) return true;
        else if(x%10==0 || x<0) return false;
        
        int i=0, result=0;
        
        while(x>result){
            result=result*10+x%10;
            x/=10;
        }
        if(x==result || x==result/10) return true;
        return false;
    }
}