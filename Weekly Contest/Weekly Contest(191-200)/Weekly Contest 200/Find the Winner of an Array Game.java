class Solution {
    public int getWinner(int[] arr, int k) {
        int max=arr[0];
        int count=0;
        int value=arr[0];
        for(int i=1; i<arr.length; i++) {
            if(value>arr[i])
                ++count;
            else{
                count=1;
                value=arr[i];
            }
            max=Math.max(max, arr[i]);
            if(count==k)
                return value;
        }
        
        return max;
    }
}
