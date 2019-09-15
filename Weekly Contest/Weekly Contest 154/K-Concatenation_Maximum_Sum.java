
class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        if(arr.length==0) return 0;
        
        int dp=0;
        int result=0;
        for(int i=0; i<arr.length; i++){     
            dp=Math.max(dp+arr[i],arr[i]);
            result=Math.max(dp,result);
        }
        
        if(k<2) return result;
        
        int leftsum=arr[0];
        int lmax=arr[0];
        int rightsum=arr[arr.length-1];
        int rmax=arr[arr.length-1];
        
        for(int i=1;i<arr.length; i++){
            leftsum+=arr[i];
            lmax=Math.max(lmax,leftsum);
        }
        
        for(int i=arr.length-2; i>=0; i--){
            rightsum+=arr[i];
            rmax=Math.max(rmax,rightsum);
        }
        
        if(leftsum<=0) return Math.max(result,lmax+rmax); 
        return Math.max(result,(int)(rmax+lmax+((k-2)*(long)leftsum)%1000000007));  //[A1, A2, A3, ......, An]  A1:rmax; An:lmax; A2...An-1: leftsum
    }
}
