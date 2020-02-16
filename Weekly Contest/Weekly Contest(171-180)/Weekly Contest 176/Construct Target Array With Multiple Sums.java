class Solution {
    public boolean isPossible(int[] target) {
        TreeSet<Integer> set=new TreeSet<Integer>();
        int sum=0;
        
        for(int i=0; i<target.length; i++) {
            int value=target[i];
            if(set.contains(value) && value!=1)
                return false;
            set.add(value);
            sum+=value;    
        }
        
        while(sum>target.length) {
            int maxnumber=set.last();
            int remain=(maxnumber<<1)-sum;
            set.remove(maxnumber);
            if(set.contains(remain) && remain!=1 || remain<1)
                return false;
            set.add(remain);
            sum=maxnumber;
        }
        
        return (set.size()==1)?true:false;
    }
}
