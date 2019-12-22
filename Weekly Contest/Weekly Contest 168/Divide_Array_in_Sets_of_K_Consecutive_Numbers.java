class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0) return false;
        
        Arrays.sort(nums);
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            int v=1;
            if(map.containsKey(nums[i])){
                v=map.get(nums[i]);
                ++v;
            }
            map.put(nums[i], v);
        }
        
        
        int count=0;
        boolean result=true;
        boolean[] visited=new boolean[nums.length];
        Arrays.fill(visited, false);
        
        while(count<nums.length){
            while(visited[count] && count<nums.length){
                ++count;
                if(count>=nums.length) break;
            }
            if(count>=nums.length) break;
            int start=count;
            int svalue=nums[start];
            visited[start]=true;
            for(int i=1; i<k; i++){
                int curr=start+map.get(nums[start]);
                if(nums[curr]-svalue!=1){
                    result=false;
                    break;
                }
                svalue=nums[curr];
                visited[curr]=true;
                start=curr;
            }
            int v=map.get(nums[start]); v--;
            map.put(nums[start], v);
            if(!result) break;
            ++count;
        }
        return result;
    }
}

/* the second implementation

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0) return false;
        
        Map<Integer, Integer> map=new TreeMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            int v=1;
            if(map.containsKey(nums[i])){
                v=map.get(nums[i]);
                ++v;
            }
            map.put(nums[i], v);
        }
        
        Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet();
        for(Map.Entry<Integer,Integer> entry : entrySet){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            while(value>0){
                for(int i=0; i<k; i++){
                    if(!map.containsKey(i+key)) return false;
                    else{
                        int v= map.get(i+key)-1;
                        map.put(i+key, v);
                    }
                }
                --value;
            }
        }
        return true;
   }
}*/
