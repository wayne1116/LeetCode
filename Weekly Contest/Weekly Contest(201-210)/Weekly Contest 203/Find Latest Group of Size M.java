// 1562. Find Latest Group of Size M
// difficulty: medium
// key point: union and find
// webseite: https://leetcode.com/problems/find-latest-group-of-size-m/

class Solution {
    int find(int node, int[] parent) {
        while(parent[node]>=0)
            node=parent[node];
        return node;
    }
    public int findLatestStep(int[] arr, int m) {
        int[] parent=new int[arr.length];
        boolean[] flag=new boolean[arr.length];
        Arrays.fill(parent, -1);
        int result=-1;
        int count=0;
        
        for(int i=0; i<arr.length; i++) {
            int index=arr[i]-1;
            flag[arr[i]-1]=true;
            int u=-1, v=-1;
            if(index-1>=0 && flag[index-1])
                u=find(index-1, parent);
            if(index+1<arr.length && flag[index+1])
                v=find(index+1, parent);
            
            if(u>=0) {
                if(-parent[u]==m)
                    --count;
                parent[index]+=parent[u];
                parent[u]=index;
            }
            if(v>=0) {
                if(-parent[v]==m)
                    --count;
                parent[index]+=parent[v];
                parent[v]=index;
            }
            
            if(-parent[index]==m) {
                ++count;
                result=i+1;
            }
            if(count>0)
                result=i+1;
        }
        
        return result;
    }
}
