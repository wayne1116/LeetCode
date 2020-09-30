// 1601. Maximum Number of Achievable Transfer Requests
// difficulty: hard
// website: https://leetcode.com/contest/weekly-contest-208/problems/maximum-number-of-achievable-transfer-requests/
class Solution {
    int result;
    public int maximumRequests(int n, int[][] requests) {
        int[] hasSpace=new int[n];
        int result=0;
        int mask=1<<requests.length;
        for(int i=1; i<mask; i++) {
            int count=0;
            for(int j=0; j<requests.length; j++) {
                if((i&(1<<j))!=0) {
                    ++count;
                    int from=requests[j][0];
                    int to=requests[j][1];
                    hasSpace[from]-=1;
                    hasSpace[to]+=1;
                }
            }    
            boolean flag=true;
            for(int j=0; j<n; j++) {
                if(hasSpace[j]!=0)
                    flag=false;
                hasSpace[j]=0;
            }
            if(flag)
                result=Math.max(result, count);
        }
        return result;
    }
}
