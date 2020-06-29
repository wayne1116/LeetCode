class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] count=new int[k+1];
        Arrays.fill(count, 0);
        for(int i=0; i<arr.length; i++) {
            int mod=arr[i]%k;
            if(mod<0)
                --count[-mod];
            else
                ++count[mod];
        }
        
        if(count[0]%2==1)
            return false;
        
        for(int i=1; i<k; i++) {
            if(count[i]!=0 && count[k-i]!=count[i])
                return false;
        }
        
        return true;
    }
}
