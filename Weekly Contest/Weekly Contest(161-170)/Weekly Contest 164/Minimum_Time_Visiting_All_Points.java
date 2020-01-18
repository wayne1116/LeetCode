class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int point1=points[0][0];
        int point2=points[0][1];
        int result=0;
        
        for(int i=1; i<points.length; i++){
            result+=Math.max(Math.abs(points[i][0]-point1), Math.abs(points[i][1]-point2));
            point1=points[i][0];
            point2=points[i][1];
        }
        return result;
    }
}
