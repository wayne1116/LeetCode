class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int result=0;
        long max_width=0;
        long max_height=0;
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        max_width=horizontalCuts[0];
        for(int i=1; i<horizontalCuts.length; i++){
            max_width=Math.max(max_width, horizontalCuts[i]-horizontalCuts[i-1]);
        }
        max_width=Math.max(max_width, h-horizontalCuts[horizontalCuts.length-1]);
        
        max_height=verticalCuts[0];
        for(int i=1; i<verticalCuts.length; i++){
            max_height=Math.max(max_height, verticalCuts[i]-verticalCuts[i-1]);
        }
        max_height=Math.max(max_height, w-verticalCuts[verticalCuts.length-1]);
        
        return (int)((max_height*max_width)%1000000007);
    }
}
