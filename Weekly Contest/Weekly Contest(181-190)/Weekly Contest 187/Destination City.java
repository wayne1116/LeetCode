class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map=new HashMap<String, Integer>();
        for(int i=0; i<paths.size(); i++) {
            List<String> t=paths.get(i);
            map.put(t.get(0), map.getOrDefault(t.get(0), 0)|1);
            map.put(t.get(1), map.getOrDefault(t.get(1), 0)|2);
        }
        
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        String result=iter.next().getKey();
        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next(); 
            if(entry.getValue()==2){
                result=entry.getKey();
                break;
            }
        }
        
        return result;
    }
}
