class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        int diff=1;
        int val=arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]!=val){
                val=arr[i];
                ++diff;
            }
        }
        
        int[][] count=new int[diff][2];
        diff=0;
        val=arr[0];
        count[0][0]=val;
        count[0][1]=1;
        for(int i=1; i<arr.length; i++){
            if(arr[i]!=val){
                val=arr[i];
                ++diff;
                count[diff][0]=val;
                count[diff][1]=1;
            }
            else ++count[diff][1];
        }
        
        Arrays.sort(count, (a,b)->b[1]-a[1]);
        while(diff>=0){
            if(k<count[diff][1])
                break;
            k-=count[diff][1];
            --diff;
        }
        
        return diff+1;
    }
}
