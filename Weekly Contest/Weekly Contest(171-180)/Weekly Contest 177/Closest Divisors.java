class Solution {
    public int[] closestDivisors(int num) {
        int target1=num+1;
        int target2=num+2;
        int limit1=(int)Math.sqrt(target1);
        int limit2=(int)Math.sqrt(target2);
        int[] result1=new int[2];
        int[] result2=new int[2];
        
        solv(result1, target1, limit1);
        solv(result2, target2, limit2);
        if(Math.abs(result1[0]-result1[1])>Math.abs(result2[0]-result2[1]))
            return result2;
        return result1;
        
    }
    void solv(int[] result, int target, int limit) {
        for(int i=limit; i>=1; i--) {
            if(target%i==0){
                result[0]=i;
                result[1]=target/i;
                break;
            }
        }
    }
}
