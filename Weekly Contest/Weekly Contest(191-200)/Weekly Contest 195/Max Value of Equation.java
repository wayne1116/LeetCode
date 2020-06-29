class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
           public int compare(int[] a, int [] b) {
               return b[0]-a[0];
           } 
        });
        
        int start=1;
        int result=-2147483648;
        for(int i=0; i<points.length; i++) {
            while(start<points.length) {
                if(points[start][0]-points[i][0]>k)
                    break;
                pq.offer(new int[]{points[start][1]+points[start][0]+100000001,start});
                ++start;
            }
            
            int[] temp;
            while(pq.size()>0) {
                temp=pq.peek();
                if(temp[1]>i)
                    break;
                pq.poll();
            }
            
            if(pq.size()==0)
                continue;
            temp=pq.peek();
            result=Math.max(result, points[i][1]+temp[0]-(points[i][0]+100000001));
        }
        
        return result;
    }
}
