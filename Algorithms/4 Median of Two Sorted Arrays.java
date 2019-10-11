class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
		int n = nums2.length;
		if(m>n){
			int[] temp = nums1;
			nums1=nums2;
			nums2=temp;
			int temp1 = m;
			m=n;
			n=temp1;
		}
		
		int imin = 0;
		int imax = m;
		int median = (n+m+1)>>1;
		
		while(imin<=imax){                      // nums1 -> m  / nums2 -> n   m<=n
			int i = (imin+imax)>>1;             // nums1
			int j = median-i;  					// nums2
			if(i<imax && nums2[j-1]>nums1[i]){
				imin = i+1;
			}
			else if(i>imin && nums1[i-1]>nums2[j]){
				imax = i-1;
			}
			else{
				int maxleft = 0;
				if(i==0) maxleft = nums2[j-1];
				else if(j==0) maxleft = nums1[i-1];
				else maxleft = Math.max(nums1[i-1],nums2[j-1]);
				
				if((m+n)%2==1) return maxleft;
				
				int minright = 0;
				if(i==m) minright = nums2[j];
				else if(j==n) minright = nums1[i];
				else minright = Math.min(nums1[i], nums2[j]);
				
				return (maxleft+minright)/2.0;
			}
		}
		
		return 0.0;
    }
}