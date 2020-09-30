// 1599. Maximum Profit of Operating a Centennial Wheel
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-208/problems/maximum-profit-of-operating-a-centennial-wheel/
class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int value=Integer.MIN_VALUE;
        int result=-1;
        int waiting=0;
        int rotate=0;
        int total=0;
        
        for(int i=0; i<customers.length; i++) {
            waiting+=customers[i];
            if(waiting>=4){
                waiting-=4;
                total+=4;
            }
            else{
                total+=waiting;
                waiting=0;
            }
            rotate+=1;
            if(value<total*boardingCost-rotate*runningCost) {
                value=total*boardingCost-rotate*runningCost;
                result=rotate;
            }
        }
        
        while(waiting>0) {
            rotate+=1;
            if(waiting>=4){
                waiting-=4;
                total+=4;
            }
            else{
                total+=waiting;
                waiting=0;
            }
            if(value<total*boardingCost-rotate*runningCost) {
                value=total*boardingCost-rotate*runningCost;
                result=rotate;
            }
        }
        
        return value<0?-1:result;
    }
}
