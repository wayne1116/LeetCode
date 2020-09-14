// 1585. Check If String Is Transformable With Substring Sort Operations
// difficulty: hard

class Solution {
    public boolean isTransformable(String s, String t) {
        Map<Integer, List<Integer>> map=new HashMap<Integer, List<Integer>>();
        for(int i=0; i<10; i++)
            map.put(i, new ArrayList<Integer>());
        for(int i=0; i<s.length(); i++) {
            List<Integer> temp=map.get(s.charAt(i)-'0');
            temp.add(i);
        }
        
        int[] count=new int[10];
        for(int i=0; i<t.length(); i++) {
            int d=t.charAt(i)-'0';
            if(count[d]>=map.get(d).size())
                return false;
            int dpos=map.get(d).get(count[d]);
            for(int j=0; j<d; j++) {
                if(count[j]<map.get(j).size() && dpos>map.get(j).get(count[j]))
                    return false;
            }
            ++count[d];
        }
        
        return true;
    }
}
