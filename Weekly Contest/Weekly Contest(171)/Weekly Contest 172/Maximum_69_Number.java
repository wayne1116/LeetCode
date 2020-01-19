class Solution {
    public int maximum69Number (int num) {
        int[] number=new int[5];
        int len=0;
        while(num>0){
            number[len]=num%10;
            num/=10;
            ++len;
        }
        for(int i=len-1; i>=0; i--){
            if(number[i]==6){
                number[i]=9;
                break;
            }
        }
        int result=0;
        for(int i=len-1; i>=0; i--) result=result*10+number[i];
        return result;
    }
}
