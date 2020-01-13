class Solution {
    public int[] sumZero(int n) {
        int len=n/2;
        int[] result=new int[n];
        int tmp=-n;
        for(int i=0; i<len; i++){
            result[i]=tmp;
            tmp+=2;
        }
        if(n%2==1){
            if(len>0)tmp=-result[len-1];
            result[len++]=0;
        }
        else tmp=-result[len-1];
        
        for(int i=len; i<n; i++){
            result[i]=tmp;
            tmp+=2;
        }
        return result;
    }
}
