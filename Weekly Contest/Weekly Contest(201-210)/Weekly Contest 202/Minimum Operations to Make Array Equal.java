class Solution {
    public int minOperations(int n) {
        int result=0;
        for(int i=1; i<=n; i+=2) {
            result+=n-i;
        }
        
        return result;
    }
}
