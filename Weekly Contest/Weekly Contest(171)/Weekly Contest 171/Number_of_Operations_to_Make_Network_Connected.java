class Solution {
    int[] parent;
    int find(int v){
        while(parent[v]>=0) v=parent[v];
        return v;
    }
    public int makeConnected(int n, int[][] connections) {
        int len=0;
        parent=new int[n];
        
        for(int i=0; i<n; i++) parent[i]=-1;
        for(int i=0; i<connections.length; i++){
            int node1=connections[i][0];
            int node2=connections[i][1];
            node1=find(node1);
            node2=find(node2);
            if(node1!=node2){
                if(parent[node1]>parent[node2]){
                    parent[node2]+=parent[node1];
                    parent[node1]=node2;
                }
                else{
                    parent[node1]+=parent[node2];
                    parent[node2]=node1;
                }
                ++len;
            }
        }
        
        int need=n-1-len;
        int remain=connections.length-len;
        return remain>=need?need:-1;
    }
}
