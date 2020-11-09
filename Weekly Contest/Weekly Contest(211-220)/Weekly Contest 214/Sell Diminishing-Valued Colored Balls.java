// 1648. Sell Diminishing-Valued Colored Balls
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-214/problems/sell-diminishing-valued-colored-balls/

class Solution {
    public int maxProfit(int[] inventory, int orders) {
        if(inventory.length==1)
            return (int)(((long)(2*inventory[0]-orders+1)*orders/2)%1000000007);
                         
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               return b[0]-a[0];
           } 
        });
        
        for(int i=0; i<inventory.length; i++)
            pq.offer(new int[]{inventory[i], 1});
        
        pq.offer(new int[]{0, 1});
        long total=0;
        while(orders>0) {
            int[] t=pq.poll();
            int diff=t[0]-pq.peek()[0];
            if(orders>=diff*t[1]) {
                orders-=diff*t[1];
                total+=(long)(2*t[0]-diff+1)*diff*t[1]/2;
                pq.peek()[1]+=t[1];
            }
            else{
                int mod=orders/t[1];
                total+=(long)(2*t[0]-mod+1)*mod*t[1]/2;
                orders%=t[1];
                total+=orders*(long)(t[0]-mod);
                orders=0;
                break;
            }
        }
        
        return (int)(total%1000000007);
    }
}
