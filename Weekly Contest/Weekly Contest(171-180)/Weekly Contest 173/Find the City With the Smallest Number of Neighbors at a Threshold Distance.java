class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph=new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(graph[i], 0);
        for(int i=0; i<edges.length; i++){
            int a=edges[i][0];
            int b=edges[i][1];
            int v=edges[i][2];
            graph[a][b]=v;
            graph[b][a]=v;
        }
        
        int result=0;
        int mincount=n;
        int[] dis=new int[n];
        boolean[] selected=new boolean[n];
        for(int i=n-1; i>=0; i--){
            Arrays.fill(selected, false);
            Arrays.fill(dis, 10000000);
            selected[i]=true;
            dis[i]=0;
            int start=i;
            for(int j=0; j<n-1; j++){
                for(int k=0; k<n; k++){
                    if(graph[start][k]>0)
                        dis[k]=Math.min(dis[k], graph[start][k]+dis[start]);       
                }
                int max=10000000;
                for(int k=0; k<n; k++){
                    if(selected[k]==false && dis[k]<max){
                        start=k;
                        max=dis[k];
                    }
                }
                selected[start]=true;
            }
            
            int count=0;
            for(int j=0; j<n; j++){
                if(dis[j]>0 && dis[j]<=distanceThreshold) ++count;
            }
            if(count<mincount){
                mincount=count;
                result=i;
            }
        }
        return result;
    }
}
