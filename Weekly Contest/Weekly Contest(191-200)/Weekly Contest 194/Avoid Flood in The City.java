class Solution {
    public int[] avoidFlood(int[] rains) {
        Set<Integer> set=new HashSet<Integer>();
        Map<Integer, Queue<Integer>> map=new HashMap<Integer, Queue<Integer>>();
        for(int i=rains.length-1; i>=0; i--) {
            if(map.get(rains[i])==null)
                map.put(rains[i], new LinkedList<Integer>());
            Queue<Integer> q=map.get(rains[i]);
            q.offer(i);
        }
        
        int[] result=new int[rains.length];
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
                public int compare(int[] a, int[] b)  {
                    return b[0]-a[0];
                }
        });
        for(int i=rains.length-1; i>=0; i--) {
            if(rains[i]>0) {
                if(set.contains(rains[i]))
                    return new int[0];
                result[i]=-1;
                set.add(rains[i]);
                Queue<Integer> q=map.get(rains[i]);
                q.poll();
                if(q.size()>0)
                    pq.offer(new int[]{q.peek(), rains[i]});

            } else{
                if(pq.size()>0) {
                    int[] t=pq.poll();
                    result[i]=t[1];
                    set.remove(t[1]);
                } else
                    result[i]=1;
            }
        }
        
        return result;
    }
}
