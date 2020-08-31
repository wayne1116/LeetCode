// 1561. Maximum Number of Coins You Can Get
// difficulty: medium
// website: https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int index=piles.length-2;
        int result=0;
        int left=0;
        while(index>left) {
            result+=piles[index];
            index-=2;
            ++left;
        }
        
        return result;
    }
}
