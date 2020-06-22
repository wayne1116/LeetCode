class Solution {
    int total;
    int find(int u, int[] parent) {
        while(parent[u]>=0)
            u=parent[u];
        return u;
    }
    int MST(int[] parent, int[][] edges, int[][] e, int n, int init) {
        int edge=init;
        int curr=0;
        int minCost=0;
        while(edge<n && curr<edges.length) {
            int u=find(edges[e[curr][1]][0], parent);
            int v=find(edges[e[curr][1]][1], parent);
            if(v!=u){
                minCost+=e[curr][0];
                parent[u]=v;
                ++edge;
            }
            ++curr;
        }
        return minCost;
    }
    
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[][] e=new int[edges.length][2];
        for(int i=0; i<edges.length; i++) {
            e[i][0]=edges[i][2];
            e[i][1]=i;
        }
        
        Arrays.sort(e, (a,b)->a[0]-b[0]);
        int[] parent=new int[n];
        Arrays.fill(parent, -1);
        int minCost=MST(parent, edges, e, n, 1);
        List<Integer> poss=new LinkedList<Integer>();
        for(int i=0; i<e.length; i++) {
            Arrays.fill(parent, -1);
            parent[edges[e[i][1]][0]]=edges[e[i][1]][1];
            int val=MST(parent, edges, e, n, 2)+e[i][0];
            if(val==minCost)
                poss.add(e[i][1]);
        }
        
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        result.add(new ArrayList<Integer>());
        
        for(int i=0; i<poss.size(); i++) {
            Arrays.fill(parent, -1);
            int cost=0;
            int edge=0;
            int m=poss.get(i);
            for(int j=0; j<poss.size(); j++) {
                if(i!=j) {
                    int node=poss.get(j);
                    int u=find(edges[node][0], parent);
                    int v=find(edges[node][1], parent);
                    if(u!=v) {
                        parent[u]=v;
                        ++edge;
                        cost+=edges[node][2];
                    }
                }
            }
            
            if(edge<n-1 || cost>minCost)
                result.get(0).add(m);
            else
                result.get(1).add(m);
        }
        
        return result;
    }
}
