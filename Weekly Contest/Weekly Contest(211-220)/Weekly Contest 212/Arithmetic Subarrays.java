// 1630. Arithmetic Subarrays
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-212/problems/arithmetic-subarrays/

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result=new ArrayList<Boolean>();
        for(int i=0; i<l.length; i++) {
            List<Integer> temp=new ArrayList<Integer>();
            boolean flag=true;
            for(int j=l[i]; j<=r[i]; j++)
                temp.add(nums[j]);
            Collections.sort(temp);
            int diff=temp.get(1)-temp.get(0);
            for(int j=2; j<temp.size(); j++) {
                if(temp.get(j)-temp.get(j-1)!=diff) {
                    flag=false;
                    break;
                }
            }
            if(flag)
                result.add(true);
            else
                result.add(false);
        }
        return result;
    }
}
