class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left=0;
        int right=0;
        for(int i=0; i<k; i++)
            right+=cardPoints[cardPoints.length-1-i];
        
        int result=right;
        for(int i=0; i<k; i++){
            left+=cardPoints[i];
            right-=cardPoints[cardPoints.length-k+i];
            result=Math.max(result, left+right);
        }
        
        return result;
    }
}
