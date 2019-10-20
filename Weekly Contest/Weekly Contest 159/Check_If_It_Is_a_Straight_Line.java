class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        float stdx = coordinates[0][0]-coordinates[1][0];
        float stdy = coordinates[0][1]-coordinates[1][1];
        float result = stdy/stdx;
        
        for(int i=2; i<coordinates.length; i++){
            float vecx = coordinates[0][0] - coordinates[i][0];
            float vecy = coordinates[0][1] - coordinates[i][1];
            if(result!=vecy/vecx) return false;
        }
        return true;
    }
}
