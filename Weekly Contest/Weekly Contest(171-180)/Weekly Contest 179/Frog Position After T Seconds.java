class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if(edges.length==0)
            return 1.0;
        else if(target==1)
            return 0.0;
        
        double[] result=new double[n+1];
        Map<Integer, List<Integer>> map=new HashMap<Integer, List<Integer>>();
        for(int i=1; i<=n; i++)
            map.put(i, new ArrayList<Integer>());
        
        for(int i=0; i<edges.length; i++){
            List<Integer> t1=map.get(edges[i][0]);
            List<Integer> t2=map.get(edges[i][1]);
            t1.add(edges[i][1]);
            t2.add(edges[i][0]);
        }
        
        Queue<Integer> queue=new LinkedList<Integer>();
        boolean[] visited=new boolean[n+1];
        int[] level=new int[n+1];
        double[] len=new double[n+1];
        Arrays.fill(visited, false);
        queue.offer(1);
        result[1]=1.0;
        level[1]=0;
        visited[1]=true;
        
        for(int i=1; i<=n; i++)
            len[i]=(double)map.get(i).size();
        
        while(queue.size()>0) {
            int size=queue.size();
            while(size-->0) {
                int node=queue.poll();
                visited[node]=true;
                List<Integer> t1=map.get(node);
                for(int i=0; i<t1.size(); i++){
                    int nextnode=t1.get(i);
                    if(!visited[nextnode]){
                        result[nextnode]=result[node]/len[node];
                        level[nextnode]=level[node]+1;
                        queue.offer(nextnode);
                        --len[nextnode];
                    }
                }
            }
        }
        
        if(level[target]>t)
            return 0.0;
        else if(level[target]==t)
            return result[target];
        
        if(map.get(target).size()==1)
            return result[target];
        return 0.0;
    }
}
