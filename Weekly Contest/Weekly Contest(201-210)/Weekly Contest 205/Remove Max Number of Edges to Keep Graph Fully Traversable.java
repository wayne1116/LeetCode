// 1579. Remove Max Number of Edges to Keep Graph Fully Traversable
// difficulty: hard
// keypoint: union and find
// website: https://leetcode.com/contest/weekly-contest-205/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/

class Solution {
    int find(int node, int[] parent) {
        while(parent[node]>0)
            node=parent[node];
        return node;
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] count=new int[3];
        int[] delete=new int[3];
        for(int i=0; i<edges.length; i++)
            ++count[edges[i][0]-1];
        
        int[] parent=new int[n+1];
        int result=0;
        Arrays.fill(parent, -1);
        for(int i=0; i<edges.length; i++) {
            if(edges[i][0]==3) {
                int u=edges[i][1];
                int v=edges[i][2];
                u=find(u, parent);
                v=find(v, parent);
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
                else
                    ++delete[2];
            }
        }
        if(count[2]-delete[2]==n-1)
            return edges.length-(n-1);
        
        int[] parent1=new int[n+1];
        for(int i=0; i<=n; i++)
            parent1[i]=parent[i];
        
        for(int i=0; i<edges.length; i++) {
            if(edges[i][0]==1) {
                int u=edges[i][1];
                int v=edges[i][2];
                u=find(u, parent1);
                v=find(v, parent1);
                if(u!=v) {
                    if(parent1[u]<parent1[v]) {
                        parent1[u]+=parent1[v];
                        parent1[v]=u;
                    }
                    else{
                        parent1[v]+=parent1[u];
                        parent1[u]=v;
                    }
                }
                else
                    ++delete[0];
            }
        }
        
        if(count[2]-delete[2]+count[0]-delete[0]<n-1)
            return -1;
        
        for(int i=0; i<=n; i++)
            parent1[i]=parent[i];
        
        for(int i=0; i<edges.length; i++) {
            if(edges[i][0]==2) {
                int u=edges[i][1];
                int v=edges[i][2];
                u=find(u, parent1);
                v=find(v, parent1);
                if(u!=v) {
                    if(parent1[u]<parent1[v]) {
                        parent1[u]+=parent1[v];
                        parent1[v]=u;
                    }
                    else{
                        parent1[v]+=parent1[u];
                        parent1[u]=v;
                    }
                }
                else
                    ++delete[1];
            }
        }
        
        if(count[2]-delete[2]+count[1]-delete[1]<n-1)
            return -1;
        
        return delete[2]+delete[1]+delete[0];
    }
}
