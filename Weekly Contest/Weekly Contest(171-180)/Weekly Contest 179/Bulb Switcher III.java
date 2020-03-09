class Solution {
    public int numTimesAllBlue(int[] light) {
        int max=-1;
        int i=0;
        
        for(i=0; i<light.length; i++) {
            max=Math.max(max, light[i]);
            if(light[i]==1){
                ++i;
                break;
            }
        }
        
        int result=0;
        if(i==max)
            ++result;
        
        for(int j=i; j<light.length; j++) {
            max=Math.max(max, light[j]);
            if(j+1==max)
                ++result;
        }
        return result;
    }
}
