class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] list=new List[n];
        for(int i=0; i<n; i++)
            list[i]=new ArrayList<Integer>();
        
        for(int i=0; i<edges.length; i++){
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        boolean[] visited=new boolean[n];
        Arrays.fill(visited, false);
        visited[0]=true;
        return solv(0, list, hasApple, visited, n);
    }
    
    int solv(int current, List<Integer>[] list, List<Boolean> hasApple, boolean[] visited, int n) {
        int value=0;
        for(int i=0; i<list[current].size(); i++) {
            int next=list[current].get(i);
            if(!visited[next]) {
                visited[next]=true;
                value+=solv(next, list, hasApple, visited, n);
            }
        }
        if(current!=0){
            if(hasApple.get(current) || value!=0)
                value+=2;
        }
        
        return value;
    }
}
