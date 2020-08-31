// 1560. Most Visited Sector in a Circular Track
// difficulty: Easy
// website: https://leetcode.com/problems/most-visited-sector-in-a-circular-track/
class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] count=new int[n];
        for(int i=1; i<rounds.length; i++) {
            int start=rounds[i-1]-1;
            int end=rounds[i]-1;
            while(start!=end) {
                ++count[start];
                start=(start+1)%n;
            }
        }
        ++count[rounds[rounds.length-1]-1];
        
        List<Integer> result=new ArrayList<Integer>();
        int max=count[0];
        for(int i=1; i<n; i++)
            max=Math.max(max, count[i]);
        for(int i=0; i<n; i++) {
            if(max==count[i])
                result.add(i+1);
        }
        
        return result;
    }
}
