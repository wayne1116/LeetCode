class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int maxsize=groupSizes[0];
        for(int i=1; i<groupSizes.length; i++){
            maxsize=Math.max(maxsize, groupSizes[i]);
        }
        
        Queue<Integer> queue=new LinkedList<Integer>();
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> temp;
        
        for(int i=1; i<=maxsize; i++){
            for(int j=0; j<groupSizes.length; j++){
                if(i==groupSizes[j]) queue.offer(j);
            }
            int size=i;
            temp=new ArrayList<Integer>();
            while(queue.size()>0){
                if(size<=0){
                    result.add(temp);
                    temp=new ArrayList<Integer>();
                    size=i;
                }   
                else{
                    temp.add(queue.poll());
                    --size;
                }
            }
            if(temp.size()>0) result.add(temp);
        }
        return result;
    }
}
