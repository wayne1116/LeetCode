class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> qu=new LinkedList<Integer>();
        int leftlimit=0;
        int rightlimit=arr.length-1;
        if(start>=arr.length) return false;
        
        boolean[] visited = new boolean[arr.length];
        Arrays.fill(visited, false);
        qu.offer(start);
        while(qu.size()>0){
            int node=qu.poll();
            visited[node]=true;
            if(arr[node]==0) return true;
            if(node-arr[node]>=leftlimit){
                if(!visited[node-arr[node]]) qu.offer(node-arr[node]);
            }
            if(node+arr[node]<=rightlimit){
                if(!visited[node+arr[node]]) qu.offer(node+arr[node]);
            }
        }
        return false;
    }
}
