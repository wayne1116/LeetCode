class Solution {
    public int numPoints(int[][] points, int r) {
        Arrays.sort(points, (a,b)->a[0]-b[0]);
        
        int total=(points.length+1)*points.length/2;
        int[][] dp=new int[total][4];
        int index=0;
        for(int i=0; i<points.length; i++) {
            for(int j=i+1; j<points.length; j++) {
                dp[index][0]=points[i][0];
                dp[index][1]=points[i][1];
                dp[index][2]=points[j][0];
                dp[index][3]=points[j][1];
                ++index;
            }
        }
        
        int result=1;
        for(int i=0; i<total; i++){
            int value=solv(dp[i][0], dp[i][1], dp[i][2], dp[i][3], points, r);
            result=Math.max(result, value);
        }
        
        return result;
    }
    
    int solv(int px1, int py1, int px2, int py2, int[][] points, int r) {
        //case1
        double t1=(px2-px1)/2.0;
        double t2=(py2-py1)/2.0;
        double len=t1*t1+t2*t2;
        double r1=r*r;
        double tan=0;
        if(px1!=px2 && py1!=py2)
            tan=Math.sqrt((r1-len)/len);
        
        double x0=px1+t1-t2*tan;
        double y0=py1+t1*tan+t2;
        int count1=0;        
        for(int i=0; i<points.length; i++){
            t1=points[i][0]-x0;
            t2=points[i][1]-y0;
            if(t1*t1+t2*t2<=r1)
                ++count1;
        }
        
        x0=px1+t1+t2*tan;
        y0=py1-t1*tan+t2;
        int count2=0;
        for(int i=0; i<points.length; i++){
            t1=points[i][0]-x0;
            t2=points[i][1]-y0;
            if(t1*t1+t2*t2<=r1)
                ++count2;
        }
        
        //case2
        int count3=0;
        if(len*2<=r1){
            x0=(px1+px2)/2.0;
            y0=(py1+py2)/2.0;
            for(int i=0; i<points.length; i++){
                t1=points[i][0]-x0;
                t2=points[i][1]-y0;
                if(t1*t1+t2*t2<=r1)
                    ++count3;
            }
        }
        
        return Math.max(count1, Math.max(count2, count3));
    }
}

// Reference:
// https://www.geeksforgeeks.org/angular-sweep-maximum-points-can-enclosed-circle-given-radius/
