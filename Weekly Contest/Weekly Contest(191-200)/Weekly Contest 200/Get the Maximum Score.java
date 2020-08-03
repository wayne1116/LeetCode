class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        Map<Integer, Long> value=new HashMap<Integer, Long>();
        boolean[] flag1=new boolean[nums1.length];
        boolean[] flag2=new boolean[nums2.length];
        int i=0, j=0;
        Arrays.fill(flag1, false);
        Arrays.fill(flag2, false);
        value.put(0, (long)0);
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i]==nums2[j]) {
                flag1[i]=flag2[j]=true;
                value.put(nums1[i], (long)0);
                ++i;
                ++j;
            }
            else if(nums1[i]>nums2[j])
                ++j;
            else
                ++i;
        }
        
        i=nums1.length-1;
        long sum=0;
        while(i>=0) {
            if(flag1[i]) {
                value.put(nums1[i], Math.max(value.get(nums1[i]), sum+nums1[i]));    
                sum=0;
            }
            else
                sum+=nums1[i];
            --i;
        }
        value.put(0, sum);
        j=nums2.length-1;
        sum=0;
        while(j>=0) {
            if(flag2[j]) {
                value.put(nums2[j], Math.max(value.get(nums2[j]), sum+nums2[j]));    
                sum=0;
            }
            else
                sum+=nums2[j];
            --j;
        }
        value.put(0, Math.max(value.get(0), sum));
        
        long result=0;
        result+=value.get(0);
        for(i=0; i<nums1.length; i++) {
            if(flag1[i])
                result+=value.get(nums1[i]);
        }
        
        return (int)(result%1000000007);
    }
}
