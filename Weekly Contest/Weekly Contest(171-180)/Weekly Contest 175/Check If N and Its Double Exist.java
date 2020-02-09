class Solution {
    public boolean checkIfExist(int[] arr) {
        int[] count=new int[2001];
        Arrays.fill(count, 0);
        for(int i=0; i<arr.length; i++)
            ++count[arr[i]+1000];
        
        if(count[1000]>1)
            return true;
        
        for(int i=0; i<2001; i++){
            if(i!=1000 && i%2==0){
                if(count[i]>0 && count[(i>>1)+500]>0)
                    return true;
            }
        }
        return false;
    }
}
