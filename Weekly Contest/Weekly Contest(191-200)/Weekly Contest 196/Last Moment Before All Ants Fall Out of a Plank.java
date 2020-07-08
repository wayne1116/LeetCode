class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int value1=0;
        int value2=0;
        if(left.length>0){
            value1=left[0];
            for(int i=1; i<left.length; i++) 
                value1=Math.max(value1, left[i]);
        }
        if(right.length>0) {
            value2=right[0];
            for(int i=1; i<right.length; i++)
                value2=Math.min(value2, right[i]);
            value2=n-value2;
        }
        
        return Math.max(value2, value1);
    }
}
