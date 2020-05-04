class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int row=nums.size();
        int total=0;
        for(int i=0; i<row; i++) 
            total+=nums.get(i).size();
        
        int index=0;
        int[][] temp=new int[total][2];
        for(int i=0; i<row; i++){
            List<Integer> t=nums.get(i);
            for(int j=0; j<t.size(); j++){
                temp[index][0]=i;
                temp[index][1]=j;
                ++index;
            }
        }
        
        Arrays.sort(temp, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               long sum1=a[0]+a[1];
               long sum2=b[0]+b[1];
               sum1=sum1*100001+a[1];
               sum2=sum2*100001+b[1];
               return sum1>sum2?1:-1;
           } 
        });
        
        int[] result=new int[total];
        for(int i=0; i<total; i++)
            result[i]=nums.get(temp[i][0]).get(temp[i][1]);
        
        return result;
    }
}
