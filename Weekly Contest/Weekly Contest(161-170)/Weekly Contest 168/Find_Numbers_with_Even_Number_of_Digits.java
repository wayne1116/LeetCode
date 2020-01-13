class Solution {
    public int findNumbers(int[] nums) {
        int result=0;;
        for(int i=0; i<nums.length; i++){
            int tmp=nums[i];
            int count=0;
            while(tmp>0){
                ++count;
                tmp=tmp/10;
            }
            if(count%2==0) ++result;
        }
        return result;
    }
}
