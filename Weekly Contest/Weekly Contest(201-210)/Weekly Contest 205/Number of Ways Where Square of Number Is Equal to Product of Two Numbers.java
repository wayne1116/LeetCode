// 1577. Number of Ways Where Square of Number Is Equal to Product of Two Numbers
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-205/problems/number-of-ways-where-square-of-number-is-equal-to-product-of-two-numbers/

class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        return solv(nums1, nums2)+solv(nums2, nums1);
    }
    
    int solv(int[] nums1, int[] nums2) {
        Map<Long, Integer> map=new HashMap<Long, Integer>();
        for(int i=0; i<nums1.length; i++){
            long target=nums1[i];
            target*=nums1[i];
            map.put(target, map.getOrDefault(target, 0)+1);
        }
        
        int result=0;
        for(int i=0; i<nums2.length; i++) {
            long t=nums2[i];
            for(int j=i+1; j<nums2.length; j++) {
                if(map.get(t*nums2[j])!=null) {
                    result+=map.get(t*nums2[j]);
                }
            }
        }
        
        return result;
    }
}
