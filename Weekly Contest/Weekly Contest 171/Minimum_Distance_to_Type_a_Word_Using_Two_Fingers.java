class Solution {
    public int minimumDistance(String word) {
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        Queue<List<Integer>> queue=new LinkedList<List<Integer>>();
        List<Integer> temp=new ArrayList<Integer>();
        temp.add((int)word.charAt(0)-64);
        temp.add(0);
        temp.add(0);
        queue.offer(temp);
        
        for(int i=1; i<word.length(); i++){
            int c=(int)word.charAt(i)-64;
            while(queue.size()>0){
                temp=queue.poll();
                int fing1=temp.get(0);
                int fing2=temp.get(1);
                int value=temp.get(2);
                
                int dis1=Math.abs((fing1-1)/6-(c-1)/6)+Math.abs((fing1-1)%6-(c-1)%6);
                int hashv1=c*27+fing2;
                if(map.containsKey(hashv1)!=false) map.put(hashv1, Math.min(map.get(hashv1), value+dis1));
                else map.put(hashv1, value+dis1);
                
                int dis2=0;
                int hashv2=fing1*27+c;
                if(fing2!=0) dis2=Math.abs((fing2-1)/6-(c-1)/6)+Math.abs((fing2-1)%6-(c-1)%6);
                if(map.containsKey(hashv2)!=false) map.put(hashv2, Math.min(map.get(hashv2), value+dis2));
                else map.put(hashv2, value+dis2);
            }
            Set keyset=map.keySet();
            Iterator it=keyset.iterator();
            while(it.hasNext()){
                Integer key=(Integer)it.next();
                Integer value=map.get(key);
                int fing1=key/27;
                int fing2=key%27;
                temp=new ArrayList<Integer>();
                temp.add(fing1);
                temp.add(fing2);
                temp.add(value);
                queue.offer(temp);
            }
            map.clear();
        }
        
        int result=2147483647;
        while(queue.size()>0){
            temp=queue.poll();
            result=Math.min(result, temp.get(2));
        }
        
        return result;
    }
}
