// 1566. Detect Pattern of Length M Repeated K or More Times
// difficulty: easy
// website: https://leetcode.com/contest/weekly-contest-204/problems/detect-pattern-of-length-m-repeated-k-or-more-times/

class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        for(int i=0; i<=arr.length-m; i++) {
            int start=i;
            int count=1;
            for(int j=i+m; j<=arr.length-m; j+=m) {
                int s=j;
                int l=0;
                for(l=0; l<m; l++) {
                    if(arr[start+l]!=arr[s+l])
                        break;
                }
                if(l>=m)
                    ++count;
                else
                    break;
            }
            if(count>=k)
                return true;
        }
        
        return false;
    }
}
