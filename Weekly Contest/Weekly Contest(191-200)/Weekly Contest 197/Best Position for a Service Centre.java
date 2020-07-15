class Solution {
    double calcudis(double startx, double starty, int px, int py) {
        double t1=startx-px;
        double t2=starty-py;
        
        return Math.sqrt(t1*t1+t2*t2);
    }
    public double getMinDistSum(int[][] positions) {
        double startx=0;
        double starty=0;
        for(int i=0; i<positions.length; i++) {
            startx+=positions[i][0];
            starty+=positions[i][1];
        }
        startx/=positions.length;
        starty/=positions.length;
        double prev=0;
        double curr=0;
        for(int i=0; i<positions.length; i++)
            curr+=calcudis(startx, starty, positions[i][0], positions[i][1]);
        
        while(Math.abs(prev-curr)>0.0000001){
            double v=0;
            double x=0.00001;
            double y=0.00001;
            for(int i=0; i<positions.length; i++) {
                double t;
                if(startx==positions[i][0] && starty==positions[i][1])
                    t=0;
                else 
                    t=1/calcudis(startx, starty, positions[i][0], positions[i][1]);
                x+=positions[i][0]*t;
                y+=positions[i][1]*t;
                v+=t;
            }
            x/=v;
            y/=v;
            
            prev=curr;
            curr=0;
            for(int i=0; i<positions.length; i++)
                curr+=calcudis(x, y, positions[i][0], positions[i][1]);
            startx=x;
            starty=y;
        }
        
        return curr;
        
    }
}
// Reference: https://www.sciencedirect.com/science/article/pii/S0898122109004234
