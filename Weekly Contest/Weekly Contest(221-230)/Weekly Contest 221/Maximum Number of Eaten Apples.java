// 1705. Maximum Number of Eaten Apples
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-221/problems/maximum-number-of-eaten-apples/

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[1]==b[1])
                    return a[0]-b[0];
                return a[1]-b[1];
            }
        });
        
        int result = 0;
        for(int i=0; i<apples.length; i++) {
            if(apples[i]>0)
                pq.offer(new int[]{apples[i], i+days[i]});
            while(pq.size()>0) {
                if(pq.peek()[1]>i)
                    break;
                pq.poll();
            }
            if(pq.size()>0) {
                int[] t = pq.poll();
                result += 1;
                t[0] -= 1;
                if(t[0]>0)
                    pq.offer(t);
            }
        }
        
        //System.out.println(result);
        int day = apples.length;
        while(pq.size()>0) {
            while(pq.size()>0) {
                if(pq.peek()[1]>day)
                    break;
                pq.poll();
            }
            if(pq.size()==0)
                break;
            int[] t = pq.poll();
            result += Math.min(t[0], t[1]-day);
            day = Math.min(t[0], t[1]-day)+day;
        }
        
        return result;
    }
}
