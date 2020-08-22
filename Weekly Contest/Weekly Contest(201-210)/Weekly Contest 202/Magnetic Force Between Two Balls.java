class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left=0;
        int right=position[position.length-1]-position[0];
        while(left<=right) {
            // 每一個間隔不得少於middle
            int middle=(left+right)>>1;
            int i=1, j=1;
            int start=position[0]+middle;
            while(i<position.length && j<m) {
                if(position[i]>=start) {
                    ++j;
                    start=position[i]+middle;
                }
                ++i;
            }
            if(j<m)
                right=middle-1;
            else
                left=middle+1;
        }
                
        return left-1;
    }
}
