class Solution {
    public boolean isGoodArray(int[] nums) {
        int value = nums[0];
        for(int i=0; i<nums.length; i++){
            value = gcd(value, nums[i]);
            if(value==1) return true;
        }
        return false;
    }
    int gcd(int a, int b)
    {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
