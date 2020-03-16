class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers=new int[n][2];
        for(int i=0; i<n; i++) {
            engineers[i][0]=efficiency[i];
            engineers[i][1]=speed[i];
        }
        
        Arrays.sort(engineers, new Comparator<int[]>(){
           public int compare(int[] a, int[] b) {
               return b[0]-a[0];
           } 
        });
        
        PriorityQueue<Long> qu=new PriorityQueue<Long>();
        long s=0;
        long result=Long.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(i>=k)
                s-=qu.poll();

            qu.offer((long)engineers[i][1]);
            s+=engineers[i][1];
            result=Math.max(result, s*engineers[i][0]);
        }
        
        return (int)(result%1000000007);
    }
}
