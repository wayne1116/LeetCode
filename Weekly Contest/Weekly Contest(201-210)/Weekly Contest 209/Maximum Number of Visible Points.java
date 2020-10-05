// 1610. Maximum Number of Visible Points
// difficulty: hard
// website: https://leetcode.com/contest/weekly-contest-209/problems/maximum-number-of-visible-points/
// keypoint: sorted by the angle

class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int count=0;
        int x=location.get(0), y=location.get(1);
        for(int i=0; i<points.size(); i++) {
            if(points.get(i).get(0)==x && points.get(i).get(1)==y)
                ++count;
        }
        double[] value=new double[(points.size()-count)*2];
        int index=0;
        for(int i=0; i<points.size(); i++) {
            double x1=points.get(i).get(0)-x;
            double y1=points.get(i).get(1)-y;
            if(x1!=0 || y1!=0) {
                double r=Math.atan2(y1, x1)*(180/Math.PI);
                value[index++]=r;
                value[index++]=r+360;
            }
        }
        
        Arrays.sort(value);
        int result=1;
        index=0;
        for (int i=1; i<value.length; i++) {
            while(index<i && value[i]-value[index]>angle)
                ++index;
            result = Math.max(result, i-index+1);
        }
        
        return result+count;
    }
}
