// 1774. Closest Dessert Cost
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-230/problems/closest-dessert-cost/

class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int result = baseCosts[0];
        int diff = Math.abs(target - result); 
        int number = 1 << (toppingCosts.length*2);
        int mask1 = (1 << toppingCosts.length)-1;
        for(int i=0; i<baseCosts.length; i++) {
            for(int j=0; j<number; j++) {
                int t1 = j & mask1;
                int t2 = j >> toppingCosts.length;
                int value = baseCosts[i];
                for(int k=0; k<toppingCosts.length; k++) {
                    if(((1<<k)&t1)!=0)
                        value += toppingCosts[k];
                    if(((1<<k)&t2)!=0)
                        value += toppingCosts[k];
                }
                if(Math.abs(value-target)<diff) {
                    diff = Math.abs(value-target);
                    result = value;
                }
                else if(Math.abs(value-target)==diff)
                    result = Math.min(result, value);
            }
        }
        
        return result;
    }
}
