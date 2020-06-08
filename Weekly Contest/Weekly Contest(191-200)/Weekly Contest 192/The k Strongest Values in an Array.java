class Solution {
    public int[] getStrongest(int[] arr, int k) {
        if(arr.length==k)
            return arr;
        
        int[][] temp=new int[arr.length][2];
        for(int i=0; i<arr.length; i++) {
            temp[i][0]=arr[i];
            temp[i][1]=0;
        }
        Arrays.sort(temp, (a,b)->(a[0]-b[0]));
        int median=temp[(arr.length-1)>>1][0];
        for(int i=0; i<arr.length; i++){
            temp[i][1]=Math.abs(median-temp[i][0]);
        }
        Arrays.sort(temp, (a,b)->(a[1]==b[1]?b[0]-a[0]:b[1]-a[1]));
        
        int[] result=new int[k];
        for(int i=0; i<k; i++)
            result[i]=temp[i][0];
        
        return result;
    }
}
