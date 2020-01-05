//import java.util.Map.Entry;
class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int[] lev=new int[friends.length];
        int index=1;
        for(int i=0; i<lev.length; i++) lev[i]=-1;
        Queue<Integer> qu = new LinkedList<Integer>();
        lev[id]=0;
        for(int i=0; i<friends[id].length; i++){
            int f=friends[id][i];
            qu.offer(f);
            lev[f]=index;
        }
        while(qu.size()>0){
            if(index==level) break;
            int len=qu.size();
            ++index;
            while(len-->0){
                int v=qu.poll();
                for(int i=0; i<friends[v].length; i++){
                    int f=friends[v][i];
                    if(lev[f]==-1){
                        lev[f]=index; 
                        qu.offer(f);
                    }
                }
            }
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<friends.length; i++){
            if(lev[i]==level){
                List<String> tmp=watchedVideos.get(i);
                for(int j=0; j<tmp.size(); j++){
                    int v=0;
                    if(map.containsKey(tmp.get(j))) v=map.get(tmp.get(j));
                    ++v;
                    map.put(tmp.get(j), v);
                }
            }
        }
		    List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            if(o1.getValue()==o2.getValue()) return o1.getKey().compareTo(o2.getKey());
            return o1.getValue() - o2.getValue();
        }
        });
        List<String> result = new ArrayList<String>();
        for(Map.Entry<String, Integer> mapping:list){ 
            result.add(mapping.getKey());
        } 
        return result;
    }
}
