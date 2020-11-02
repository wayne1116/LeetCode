// 1642. Furthest Building You Can Reach
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-213/problems/furthest-building-you-can-reach/
// keypoint: 
// At first use all the ladders you have. When no ladder can use, 
// choose the smallest difference height between two buildings and use bricks to replace one ladder, 
// so now you have one ladder whatever you want to use.

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        int i=0;
        while(i<heights.length-1) {
            if(heights[i]<heights[i+1]) {
                if(ladders>0){
                    pq.offer(heights[i+1]-heights[i]);
                    ladders-=1;
                }
                else{
                    if(pq.size()>0 && pq.peek()<=bricks) {
                        bricks-=pq.poll();
                        pq.offer(heights[i+1]-heights[i]);
                    }
                    else if(bricks>=heights[i+1]-heights[i])
                        bricks-=heights[i+1]-heights[i];
                    else
                        break;
                }
            }
            ++i;
        }
        return i;
    }
}
