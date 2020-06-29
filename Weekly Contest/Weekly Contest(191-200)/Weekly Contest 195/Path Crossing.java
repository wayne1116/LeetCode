class Solution {
    public boolean isPathCrossing(String path) {
        long x=0;
        long y=0;
        Set<Long> set=new HashSet<Long>();
        set.add((x+10000)*10001+y+10000);
        for(int i=0; i<path.length(); i++) {
            char c=path.charAt(i);
            if(c=='N')
                ++y;
            else if(c=='S')
                --y;
            else if(c=='E')
                ++x;
            else
                --x;
            
            long v=(x+10000)*10001+y+10000;
            if(set.contains(v))
                return true;
            set.add(v);
            
        }
        return false;
    }
}
