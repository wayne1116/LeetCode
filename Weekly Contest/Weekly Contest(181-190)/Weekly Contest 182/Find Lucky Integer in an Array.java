class Solution {
    public int findLucky(int[] arr) {
        int[] freq=new int[512];
        Arrays.fill(freq, 0);
        
        for(int i=0; i<arr.length; i++)
            ++freq[arr[i]];
        
        for(int i=511; i>0; i--){
            if(freq[i]==i)
                return i;
        }
        return -1;
    }
}
