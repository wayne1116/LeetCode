// 1691. Maximum Height by Stacking Cuboids
// difficulty: hard
// website: https://leetcode.com/contest/weekly-contest-219/problems/maximum-height-by-stacking-cuboids/

class Solution {
    public int maxHeight(int[][] cuboids) {
        int[] dp=new int[cuboids.length];
        for(int i=0; i<cuboids.length; i++) {
            for(int j=0; j<3; j++) {
                for(int k=j+1; k<3; k++) {
                    if(cuboids[i][j]>cuboids[i][k]) {
                        int temp=cuboids[i][j];
                        cuboids[i][j] = cuboids[i][k];
                        cuboids[i][k] = temp;
                    }
                }
            }
        }
        Arrays.sort(cuboids, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[2]==b[2])
                    return a[1]==b[1]?a[0]-b[0]:a[1]-b[1];
                return a[2]-b[2];
            }  
        });
        for(int i=0; i<cuboids.length; i++) {
            for(int j=0; j<3; j++)
                dp[i] = cuboids[i][2];
        }
        
        for(int i=0; i<dp.length; i++) {
            for(int j=i-1; j>=0; j--) {
                if(cuboids[j][0]<=cuboids[i][0] && cuboids[j][1]<=cuboids[i][1] && cuboids[j][2]<=cuboids[i][2])
                    dp[i] = Math.max(dp[i], dp[j]+cuboids[i][2]);
            }
        }
        
        int result=0;
        for(int i=0; i<dp.length; i++)
            result = Math.max(result, dp[i]);
        
        return result;
    }
}
