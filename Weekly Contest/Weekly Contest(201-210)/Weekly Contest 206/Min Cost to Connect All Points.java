// 1584. Min Cost to Connect All Points
// difficulty: medium

class Solution {
    int find(int node, int[] parent) {
        while(parent[node]>=0)
            node=parent[node];
        return node;
    }
    public int minCostConnectPoints(int[][] points) {
        int[][] edges=new int[points.length*(points.length-1)/2][3];
        int count=0;
        for(int i=0; i<points.length; i++) {
            for(int j=i+1; j<points.length; j++) {
                edges[count][1]=i;
                edges[count][2]=j;
                edges[count][0]=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                ++count;
            }
        }
        
        Arrays.sort(edges, (a,b)->a[0]-b[0]);
        int edge=1;
        int result=0, index=0;
        int[] parent=new int[points.length];
        Arrays.fill(parent, -1);
        while(edge<points.length && index<count) {
            int u=find(edges[index][1], parent);
            int v=find(edges[index][2], parent);
            if(u!=v) {
                if(parent[u]>parent[v]) {
                    parent[v]+=parent[u];
                    parent[u]=v;
                }
                else{
                    parent[v]+=parent[u];
                    parent[u]=v;
                }
                edge++;
                result+=edges[index][0];
            }
            ++index;
        }
        
        return result;
    }
}
