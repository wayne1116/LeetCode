class Solution {
    public int divide(int dividend, int divisor) {
        long temp1 = dividend;
        long temp2 = divisor;
        int result = 0;
        if(temp1/temp2>2147483647) result=2147483647;
        else if(temp1/temp2<-2147483648) result=-2147483648;
        else result=(int)temp1/(int)temp2;
        return result;
    }
}