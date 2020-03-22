class Solution {
    public int sumFourDivisors(int[] nums) {
        int result=0;
        for(int i=0; i<nums.length; i++) {
            int value=nums[i];
            int limit=(int)Math.sqrt(value);
            
            int count=1;
            int temp=1;
            if(value!=1) {
                count=2;
                temp+=value;
            }
            for(int j=2; j<limit; j++) {
                if(value%j==0){
                    count+=2;
                    temp+=value/j+j;
                }
            }
            
            if(value%limit==0 && limit>=2) {
                count+=1;
                temp+=limit;
                if(value/limit!=limit) {
                    count+=1;
                    temp+=value/limit;
                }
            }
            
            if(count==4)
                result+=temp;
        }
        
        return result;
    }
}
