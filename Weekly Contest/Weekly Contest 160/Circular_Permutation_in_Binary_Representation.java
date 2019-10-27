class Solution {                           
    public List<Integer> circularPermutation(int n, int start) {
        int[][] temp = new int[65536][n];
        Arrays.fill(temp[0],0);
        int limit=1;
        for(int i=1; i<=n; i++) limit=limit<<1;
        
        for(int i=1; i<limit; i++){                             // gray code
            for(int j=0; j<n; j++) temp[i][j]=temp[i-1][j];
            if(i%2==1){
                if(temp[i][n-1]==0) temp[i][n-1]=1;
                else temp[i][n-1]=0;
            }
            else{
                for(int j=n-1; j>=0; j--){
                    if(temp[i][j]==1){
                        if(temp[i][j-1]==0) temp[i][j-1]=1;
                        else temp[i][j-1]=0;
                        break;
                    }
                }
            }
        }
        
        int[] number = new int[limit]; 
        for(int i=0; i<limit; i++){
            int temp1 = 0;
            for(int j=0; j<n; j++){
                temp1=(temp1<<1)+temp[i][j];
            }
            number[i]=temp1;
        }
        
        int index=0;
        for(int i=0; i<limit; i++){
            if(number[i]==start){
                index=i;
                break;
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<limit; i++){
            result.add(number[index]);
            index=(index+1)%limit;
        }
        return result;
    }
}
