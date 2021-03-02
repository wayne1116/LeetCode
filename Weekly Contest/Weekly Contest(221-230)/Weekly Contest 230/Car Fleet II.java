// 1776. Car Fleet II
// difficulty: hard
// website: https://leetcode.com/contest/weekly-contest-230/problems/car-fleet-ii/

class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>(new Comparator<double[]>(){
            public int compare(double[] a, double[] b) {
                if(a[0]>b[0])
                    return 1;
                return -1;
            }
        });
        
        double[] result = new double[cars.length];
        int[][] connected = new int[cars.length][2];
        result[cars.length-1] = -1;
        connected[0][0] = -1;
        connected[cars.length-1][1] = -1;
        for(int i=0; i<cars.length-1; i++) {
            result[i] = -1;
            connected[i][1] = i+1;
            connected[i+1][0] = i;
            if(cars[i][1]>cars[i+1][1]){
                double dist = cars[i+1][0] - cars[i][0];
                double x = cars[i+1][1]*dist/(cars[i][1] - cars[i+1][1]);
                double time = x / cars[i+1][1];
                pq.offer(new double[]{time, i});
            }
        }
        
        while(pq.size()>0) {
            while(pq.size()>0) {
                double[] t = pq.peek();
                if(result[(int)t[1]] < 0)
                    break;
                pq.poll();
            }
            if(pq.size()>0) {
                double[] t = pq.poll();
                result[(int)t[1]] = t[0];
                int right = connected[(int)t[1]][1];
                int left = connected[(int)t[1]][0];
                if(right>-1) {
                    connected[right][0] = left;
                    connected[(int)t[1]][1] = connected[right][1];
                    if(left>-1)
                        connected[left][1] = right;
                    
                    if(left>-1 && cars[left][1]>cars[right][1]) {
                        double end = cars[right][1] * t[0] + cars[right][0];
                        double start = cars[left][1] * t[0] + cars[left][0];
                        double dist = end - start;
                        double x = cars[right][1]*dist/(cars[left][1] - cars[right][1]);
                        double time = x / cars[right][1];
                        pq.offer(new double[]{time+t[0], left});
                    }
                }
                
            }
        }
        
        return result;
    }
}
