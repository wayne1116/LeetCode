class Solution {
    public int subtractProductAndSum(int n) {
        int multiply=1;
        int sum=0;
        while(n>0){
            int temp=n%10;
            multiply*=temp;
            sum+=temp;
            n/=10;
        }
        return multiply-sum;
    }
}
