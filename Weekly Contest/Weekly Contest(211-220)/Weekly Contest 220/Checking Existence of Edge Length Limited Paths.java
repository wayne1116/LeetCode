// 1697. Checking Existence of Edge Length Limited Paths
// difficulty: hard
// website: https://leetcode.com/contest/weekly-contest-220/problems/checking-existence-of-edge-length-limited-paths/

class Solution {
    int find(int node, int[] parent) {
        while(parent[node]>=0)
            node = parent[node];
        return node;
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, new Comparator<int[]>(){
           public int compare(int[] a, int[] b) {
               return a[2]-b[2];
           } 
        });
        
        int edge = 1;
        int i = 0;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int[] cost = new int[n];
        while(edge<n && i<edgeList.length) {
            int[] t = edgeList[i];
            int u = find(t[0], parent);
            int v = find(t[1], parent);
            if(u!=v) {
                if(parent[u]>parent[v]) {
                    parent[v] += parent[u];
                    parent[u] = v;
                    cost[u] = t[2];
                }
                else{
                    parent[u] += parent[v];
                    parent[v] = u;
                    cost[v] = t[2];
                }
                ++edge;    
            }
            ++i;
        }
        
        boolean[] result = new boolean[queries.length];
        for(int j=0; j<queries.length; j++) {
            int node1 = queries[j][0];
            int node2 = queries[j][1];
            int u = find(node1, parent);
            int v = find(node2, parent);
            int limit = queries[j][2];
            if(u!=v)
                result[j] = false;
            else{
                Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
                Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
                int value = 0;
                while(parent[node1]>=0) {
                    value = Math.max(value, cost[node1]);
                    map1.put(parent[node1], cost[node1]);
                    node1 = parent[node1];
                }
                value = 0;
                while(parent[node2]>=0) {
                    value = Math.max(value, cost[node2]);
                    map2.put(parent[node2], cost[node2]);
                    node2 = parent[node2];
                }
                node1 = queries[j][0];
                node2 = queries[j][1];
                if(map1.get(node2)!=null)
                    result[j] = limit>map1.get(node2);
                else if(map2.get(node1)!=null)
                    result[j] = limit>map2.get(node1);
                else{
                    value = 0;
                    while(parent[node2]>=0) {
                        if(map1.get(node2)!=null) 
                            break;
                        value = Math.max(value, cost[node2]);
                        node2 = parent[node2];
                    }
                    result[j] = limit>Math.max(map1.get(node2), value);
                }
            }
        }
        
        return result;
    }
}
