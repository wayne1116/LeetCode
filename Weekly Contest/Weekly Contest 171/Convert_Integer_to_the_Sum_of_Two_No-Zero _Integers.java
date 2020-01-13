class Solution {
    public int[] getNoZeroIntegers(int n) {
        int number1=1;
        int number2=1;
        for(int i=1; i<n; i++){
            number1=i;
            number2=n-i;
            int temp1=number1;
            int temp2=number2;
            while(temp1>0){
                if(temp1%10==0) break;
                temp1/=10;
            }
            while(temp2>0){
                if(temp2%10==0) break;
                temp2/=10;
            }
            if(temp1==0 && temp2==0) break;
        }
        int[] result={number1, number2};
        return result;
    }
}
