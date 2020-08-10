class Solution {
    public char findKthBit(int n, int k) {
        int left=1;
        int right=(1<<n)-1;
        char result='1';
        while(left<right-2) {
            int middle=(left+right)>>1;
            if(middle==k)
                return result;
            else if(middle<k){
                left=middle+1;
                result='0';
            }
            else{
                right=middle-1;
                result='1';
            }
        }
        
        if(k==left)
            return '0';
        if(k==right)
            return '1';
        return result;
    }
}
