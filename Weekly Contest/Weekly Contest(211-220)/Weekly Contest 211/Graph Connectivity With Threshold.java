// 1627. Graph Connectivity With Threshold
// difficulty: hard
// website: https://leetcode.com/contest/weekly-contest-211/problems/graph-connectivity-with-threshold/
// keypoint: gcd, union-and-find
class Solution {
    int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
    int find(int node, int[] parent) {
        while(parent[node]>0)
            node=parent[node];
        return node;
    }
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        int[] parent=new int[n+1];
        Arrays.fill(parent, -1);
        for(int i=threshold+1; i<=n; i++) {
            int total=i+i;
            while(total<=n) {
                int u=find(i, parent);
                int v=find(total, parent);
                if(u!=v) {
                    if(parent[u]<parent[v]) {
                        parent[u]+=parent[v];
                        parent[v]=u;
                    }
                    else{
                        parent[v]+=parent[u];
                        parent[u]=v;
                    }
                }
                total+=i;
            }
        }
        
        List<Boolean> result=new ArrayList<Boolean>();
        for(int i=0; i<queries.length; i++) {
            int node1=queries[i][0];
            int node2=queries[i][1];
            int m=gcd(node1, node2);
            int u=find(node1, parent);
            int v=find(node2, parent);
            if(u==v || m>threshold)
                result.add(true);
            else
                result.add(false);
        }
        
        return result;
    }
}
