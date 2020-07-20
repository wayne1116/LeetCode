class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] e=new List[n];
        for(int i=0; i<n; i++)
            e[i]=new ArrayList<Integer>();
        
        for(int i=0; i<edges.length; i++) {
            e[edges[i][0]].add(edges[i][1]);
            e[edges[i][1]].add(edges[i][0]);
        }
        
        boolean[] flag=new boolean[n];
        int[] result=new int[n];
        Arrays.fill(flag, false);
        int[] t=solv(0, e, flag, labels, result);
        
        return result;
    }
    
    int[] solv(int start, List<Integer>[] e, boolean[] flag, String labels, int[] result) {
        flag[start]=true;
        int[] count=new int[26];
        Arrays.fill(count, 0);
        
        ++count[labels.charAt(start)-'a'];
        for(int i=0; i<e[start].size(); i++) {
            int node=e[start].get(i);
            if(!flag[node]) {
                int[] t=solv(node, e, flag, labels, result);
                for(int j=0; j<26; j++)
                    count[j]+=t[j];
            }
        }
        
        result[start]=count[labels.charAt(start)-'a'];
        return count;
    }
}
