// 1617. Count Subtrees With Max Distance Between Cities
// difficulty: hard
// website: https://leetcode.com/contest/weekly-contest-210/problems/count-subtrees-with-max-distance-between-cities/
// keypoint: floyd warshall and mask(check whether nodes are all connected)
class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[][] graph=new int[n+1][n+1];
        boolean[][] directConnect=new boolean[n+1][n+1];
        for(int i=0; i<=n; i++) {
            Arrays.fill(graph[i], 1000);
            graph[i][i]=0;
        }
        
        for(int i=0; i<edges.length; i++) {
            graph[edges[i][0]][edges[i][1]]=1;
            graph[edges[i][1]][edges[i][0]]=1;
            directConnect[edges[i][0]][edges[i][1]]=true;
            directConnect[edges[i][1]][edges[i][0]]=true;
        }
        
        // floyd warshall
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(graph[i][j]>graph[i][k]+graph[k][j])
                        graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }
        
        int[] result=new int[n-1];
        solv(graph, directConnect, result, 1, n+1, new ArrayList<Integer>());
        return result;
    }
    
    void solv(int[][] graph, boolean[][] directConnect, int[] result, int index, int n, List<Integer> list) {
        if(index>n)
            return;
        
        if(list.size()>1) {
            int mask=0;
            for(int i=0; i<list.size(); i++)
                mask|=(1<<list.get(i));
            Queue<Integer>queue=new LinkedList<Integer>();
            queue.offer(list.get(0));
            mask^=(1<<list.get(0));
            while(queue.size()>0) {
                int node=queue.poll();
                for(int i=1; i<n; i++) {
                    if(directConnect[node][i] && (mask&(1<<i))!=0) {
                        queue.offer(i);
                        mask^=(1<<i);
                    }
                }
            }
            
            if(mask==0) {
                int maxDistance=0;
                for(int i=0; i<list.size(); i++) {
                    int node1=list.get(i);
                    for(int j=i+1; j<list.size(); j++) {
                        int node2=list.get(j);
                        maxDistance=Math.max(maxDistance, graph[node1][node2]);
                    }
                }
                if(maxDistance>0)
                    result[maxDistance-1]+=1;
            }
        }
        
        for(int i=index; i<n; i++) {
            list.add(i);
            solv(graph, directConnect, result, i+1, n, list);
            list.remove(list.size()-1);
        }
    }
}
