class Solution {
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] next=new List[n];
        List<Integer>[] parent=new List[n];
        for(int i=0; i<n; i++){
            next[i]=new ArrayList<Integer>();
            parent[i]=new ArrayList<Integer>();
        }
        for(int i=0; i<connections.length; i++) {
            next[connections[i][0]].add(connections[i][1]);
            parent[connections[i][1]].add(connections[i][0]);
        }
        
        int result=0;
        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new LinkedList<Integer>();
        Arrays.fill(visited, false);
        visited[0]=true;
        queue.offer(0);
        
        while(queue.size()>0) {
            int v=queue.poll();
            for(int i=0; i<next[v].size(); i++) {
                int u=next[v].get(i);
                queue.offer(u);
                visited[u]=true;
            }
            for(int i=0; i<parent[v].size(); i++) {
                int u=parent[v].get(i);
                if(!visited[u]){
                    queue.offer(u);
                    visited[u]=true;
                    ++result;
                }
            }
        }
        
        return n-1-result;
    }
}
