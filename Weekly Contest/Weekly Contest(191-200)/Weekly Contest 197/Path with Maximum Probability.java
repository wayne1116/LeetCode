class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Double> map=new HashMap<Integer, Double>();
        List<Integer>[] e=new List[n];
        for(int i=0; i<n; i++)
            e[i]=new ArrayList<Integer>();
        
        for(int i=0; i<edges.length; i++) {
            e[edges[i][0]].add(edges[i][1]);
            e[edges[i][1]].add(edges[i][0]);
            int hash1=edges[i][0]*(n+1)+edges[i][1];
            int hash2=edges[i][1]*(n+1)+edges[i][0];
            map.put(hash1, succProb[i]);
            map.put(hash2, succProb[i]);
        }
        
        double[] value=new double[n];
        boolean[] flag=new boolean[n];
        Arrays.fill(value, -1.0);
        Arrays.fill(flag, false);
        value[start]=1;
        while(start!=end && start>=0) {
            flag[start]=true;
            for(int i=0; i<e[start].size(); i++) {
                int v=e[start].get(i);
                int hash=start*(n+1)+v;
                double prob=map.get(hash);
                if(value[v]<value[start]*prob){
                    value[v]=value[start]*prob;
                }
            }
            
            double max=-1;
            int index=-1;
            for(int i=0; i<n; i++) {
                if(value[i]>max && !flag[i] && value[i]>=0) {
                    max=value[i];
                    index=i;
                }
            }
            start=index;
        }
        
        return value[end]>=0?value[end]:0.0;
    }
}
