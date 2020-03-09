// Method 1
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n==1)
            return 0;
        
        Map<Integer, List<Integer>> map=new HashMap<Integer, List<Integer>>();
        Queue<Integer> queue=new LinkedList<Integer>();
        
        for(int i=0; i<n; i++)
            map.put(i, new ArrayList<Integer>());
        
        for(int i=0; i<n; i++){
            if(manager[i]>=0){
                List<Integer> temp=map.get(manager[i]);
                temp.add(i);
            }
        }
        
        
        int[] Time=new int[n];
        Time[headID]=0;
        queue.offer(headID);
        int result=0;
        
        while(queue.size()>0) {
            int size=queue.size();
            while(size-->0) {
                int person=queue.poll();
                List<Integer> temp=map.get(person);
                for(int i=0; i<temp.size(); i++){
                    int employee=temp.get(i);
                    Time[employee]=Time[person]+informTime[person];
                    result=Math.max(result, Time[employee]);
                    queue.offer(employee);
                }
            }
        }
        
        return result;
    }
}

/* Method 2
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if(n==1)
            return 0;
        
        boolean[] isparent=new boolean[n];
        Queue<Integer> queue=new LinkedList<Integer>();
        
        Arrays.fill(isparent, false);
        for(int i=0; i<n; i++){
            if(manager[i]>=0)
                isparent[manager[i]]=true;
        }
        
        int[] Time=new int[n];
        Arrays.fill(Time, -1);
        for(int i=0; i<n; i++){
            if(!isparent[i]){
                System.out.print(i+" ");
                queue.offer(i);
                Time[i]=0;
            }   
        }
        
        int result=0;
        while(queue.size()>0) {
            int size=queue.size();
            while(size-->0) {
                int person=queue.poll();
                if(person==headID)
                    continue;
                
                int time=Time[person]+informTime[manager[person]];
                if(Time[manager[person]]<0 || Time[manager[person]]<time){
                    Time[manager[person]]=time;
                    queue.offer(manager[person]);
                }
                result=Math.max(result, Time[manager[person]]);
            }
        }
        
        return result;
    }
}
*/
