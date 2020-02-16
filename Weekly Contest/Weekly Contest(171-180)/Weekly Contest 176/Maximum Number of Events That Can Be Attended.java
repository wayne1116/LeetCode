class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>(){
           public int compare(int[] a, int[] b) {
               if(a[1]==b[1])
                   return a[0]-b[0];
               return a[1]-b[1];
           } 
        });
        
        
        int result=0;
        boolean[] taken=new boolean[100001];
        Arrays.fill(taken, false);
        
        for(int i=0; i<events.length; i++) {
            for(int j=events[i][0]; j<=events[i][1]; j++) {
                if(!taken[j]) {
                    ++result;
                    taken[j]=true;
                    break;
                }
            }
        }
        return result;
    }
}
