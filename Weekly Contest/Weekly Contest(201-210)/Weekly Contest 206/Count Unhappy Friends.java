// 1583. Count Unhappy Friends
// difficulty: medium

class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int result=0;
        int[] pair=new int[n];
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0; i<pairs.length; i++) {
            int p1=pairs[i][0];
            int p2=pairs[i][1];
            pair[p1]=p2;
            pair[p2]=p1;
        }
        
        for(int i=0; i<preferences.length; i++) {
            for(int j=0; j<preferences[i].length; j++) {
                map.put(i*n+preferences[i][j], j);
            }
        }
        
        for(int i=0; i<n; i++) {
            int v=map.get(i*n+pair[i]);
            for(int j=0; j<n; j++) {
                if(i!=j && map.get(i*n+j)<v && map.get(j*n+pair[j])>map.get(j*n+i)) {
                    ++result;
                    break;
                }
            }
        }
        
        return result;
    }
}
