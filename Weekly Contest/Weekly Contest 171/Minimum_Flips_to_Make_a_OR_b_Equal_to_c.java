class Solution {
    public int minFlips(int a, int b, int c) {
        int temp=a|b;
        int result=0;
        for(int i=0; i<32; i++){
            if(temp%2!=c%2){
                if(c%2==1) ++result;
                else{
                    if(a%2==1) ++result;
                    if(b%2==1) ++result;
                }
            }
            temp>>=1;
            c>>=1;
            a>>=1;
            b>>=1;
        }
        return result;
    }
}
