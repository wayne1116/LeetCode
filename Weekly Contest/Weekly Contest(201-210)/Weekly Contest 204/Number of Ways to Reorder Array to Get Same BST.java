// 1569. Number of Ways to Reorder Array to Get Same BST
// difficulty: hard
// website: https://leetcode.com/contest/weekly-contest-204/problems/number-of-ways-to-reorder-array-to-get-same-bst/

// Method 1 : using Pascal's Triangle
class Solution {
	public int numOfWays(int[] nums) {
		int[][] child=new int[nums.length+1][2];
		long[][] c=new long[nums.length+1][nums.length+1];
		int rootIndex=nums[0];
    
		// Pascal's Triangle
		for(int i=0; i<=nums.length; i++)
			c[i][0]=1;
		for(int i=1; i<=nums.length; i++) {
			for(int j=1; j<=i; j++)
				c[i][j]=(c[i-1][j-1]+c[i-1][j])%1000000007;
		}
    
		// build the binary tree
		for(int i=1; i<nums.length; i++) {
			int prev=nums[0];
			rootIndex=nums[0];
			while(rootIndex>0) {
				prev=rootIndex;
				if(rootIndex>nums[i])
					rootIndex=child[rootIndex][0];
				else
					rootIndex=child[rootIndex][1];
			}
			if(prev>nums[i])
				child[prev][0]=nums[i];
			else
				child[prev][1]=nums[i];
		}
    
		long[] result=solv(child, nums[0], c);
		return (int)(result[1]-1);
	}

	long[] solv(int[][] child, int root, long[][] c) {
		if(root==0)
			return new long[]{0, 0}; 
    
		long[] left=solv(child, child[root][0], c);
		long[] right=solv(child, child[root][1], c);
		if(left[0]==0 && right[0]==0)
			return new long[]{1, 1};
		if(left[0]==0)
			return new long[]{right[0]+1, right[1]};
		if(right[0]==0)
			return new long[]{left[0]+1, left[1]};
    
		long result=(left[1]*right[1])%1000000007;
		long total=left[0]+right[0];
		result=(result*c[(int)total][(int)left[0]])%1000000007;
    
		return new long[]{total+1, result};
	}
}


// Method 2: using BigInteger
import java.math.BigInteger;
class Solution {
    BigInteger one=new BigInteger("1");
    BigInteger zero=new BigInteger("0");
    public int numOfWays(int[] nums) {
        int[][] child=new int[nums.length+1][2];
        int rootIndex=nums[0];
        for(int i=1; i<nums.length; i++) {
            int prev=nums[0];
            rootIndex=nums[0];
            while(rootIndex>0) {
                prev=rootIndex;
                if(rootIndex>nums[i])
                    rootIndex=child[rootIndex][0];
                else
                    rootIndex=child[rootIndex][1];
            }
            if(prev>nums[i])
                child[prev][0]=nums[i];
            else
                child[prev][1]=nums[i];
        }
        
        BigInteger[] result=solv(child, nums[0]);
        return result[1].subtract(one).mod(new BigInteger("1000000007")).intValue();
    }
    
    BigInteger[] solv(int[][] child, int root) {
        if(root==0)
            return new BigInteger[]{zero, zero}; 
        
        BigInteger[] left=solv(child, child[root][0]);
        BigInteger[] right=solv(child, child[root][1]);
        if(left[0].intValue()==0 && right[0].intValue()==0)
            return new BigInteger[]{one, one};
        if(left[0].intValue()==0)
            return new BigInteger[]{right[0].add(one), right[1]};
        if(right[0].intValue()==0)
            return new BigInteger[]{left[0].add(one), left[1]};
        
        BigInteger result=left[1].multiply(right[1]);
        int total=left[0].intValue()+right[0].intValue();
        for(int i=0; i<left[0].intValue(); i++) {
            result=result.multiply(new BigInteger(Integer.toString(total-i)));
            result=result.divide(new BigInteger(Integer.toString(i+1)));
        }
        
        
        return new BigInteger[]{new BigInteger(Integer.toString(total+1)), result};
    }
}
