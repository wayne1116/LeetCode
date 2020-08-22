// Method 1
class Solution {
    public int minDays(int n) {
        Set<Integer> set=new HashSet<Integer>();
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.offer(n);
        int result=0;
        while(queue.size()>0) {
            int currSize=queue.size();
            while(currSize-->0) {
                int v=queue.poll();
                if(v==0)
                    return result;
                if(v%3==0 && !set.contains(v/3)) {
                    queue.offer(v/3);
                    set.add(v/3);
                }
                if(v%2==0 && !set.contains(v/2)) {
                    queue.offer(v/2);
                    set.add(v/2);
                }
                if(!set.contains(v-1)) {
                    queue.offer(v-1);
                    set.add(v-1);
                }
            }
            ++result;
        }
        
        return result;
    }
}

// Method 2
class Solution {
    Map<Integer, Integer> map;
    public int minDays(int n) {
        map=new HashMap<Integer, Integer>();
        return solv(n)-1;
    }
    
    int solv(int n) {
        if(n<=0)
            return 0;
        if(map.containsKey(n))
            return map.get(n);
        
        map.put(n, 1+Math.min((n%2)+solv(n/2), (n%3)+solv(n/3)));
        
        return map.get(n);
    }
}
