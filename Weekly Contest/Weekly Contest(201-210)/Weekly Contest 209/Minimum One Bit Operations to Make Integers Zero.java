// 1611. Minimum One Bit Operations to Make Integers Zero
// difficulty: hard
// website: https://leetcode.com/contest/weekly-contest-209/problems/minimum-one-bit-operations-to-make-integers-zero/

class Solution {
    public int minimumOneBitOperations(int n) {
        if(n==0)
            return 0;
        
        int th=0;
        for(int i=31; i>=0; i--) {
            if((n&(1<<i))!=0) {
                th=1<<i;
                break;
            }
        }
        
        return (2*th-1)-minimumOneBitOperations(n-th);
    }
}
