class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length)
            return -1;
        
        //int[] sorted=new int[bloomDay.length];
        //for(int i=0; i<bloomDay.length; i++)
        //    sorted[i]=bloomDay[i];
        //Arrays.sort(sorted);
        
        int left=0;
        int right=1000000001;
        while(left<=right) {
            int middle=(left+right)>>1;
            //int val=sorted[middle];
            int count=0;
            int result=0;
            for(int i=0; i<bloomDay.length; i++) {
                if(bloomDay[i]<=middle) {
                    ++count;
                    if(count==k){
                        count=0;
                        ++result;
                    }
                }
                else count=0;
            }
            if(result<m)
                left=middle+1;
            else
                right=middle-1;
        }
        
        return left;
    }
}
