// 1707. Maximum XOR With an Element From Array
// diffciulty: hard
// website: https://leetcode.com/contest/weekly-contest-221/problems/maximum-xor-with-an-element-from-array/

class Solution {
    class Trie{
        public int value;
        public Trie left;
        public Trie right;
        public Trie(int v) {
            value = v;
            left = right = null;
        }
    }
    void binary(int value, int[] bits) {
        for(int j=31; j>=0; j--) {
            int bit = 0;
            if(((1<<j)&value)!=0)
                bit = 1;
            bits[j] = bit;
        }
    }

    int[] findMaxValue(Trie current, int[] limit, int[] bits, int level, int value, boolean flag, int xi) {
        if(level<0) 
            return new int[]{value, 1};
        
        if(flag) {            
            for(int i=level; i>=0; i--) {
                if(bits[i]==0 && current.left!=null)
                    current = current.left;
                else if(bits[i]==1 && current.right!=null)
                    current = current.right;
                else if(current.left!=null)
                    current = current.left;
                else
                    current = current.right;
                value += (1<<i)*current.value;
            }
            return new int[]{value, 1};
        }
        if(limit[level]==1 && current.left!=null && bits[level]==0){
            int[] f = findMaxValue(current.left, limit, bits, level-1, value, true, xi);
            if(f[1]==1)
                return f;
        }
        int[] f1=null;
        if(limit[level]==1 && current.right!=null) 
            f1 = findMaxValue(current.right, limit, bits, level-1, value+(1<<level), false, xi);
        int[] f2=null;
        if(current.left!=null)
            f2 = findMaxValue(current.left, limit, bits, level-1, value, false | limit[level]==1, xi);
        
        if(f1!=null && f2!=null) 
            return ((f1[0]^xi)>(f2[0]^xi))?f1:f2;
        if(f1!=null)
            return f1;
        if(f2!=null)
            return f2;
        
        return new int[]{-1,0};
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        Trie root = new Trie(-1);
        for(int i=0; i<nums.length; i++) {
            Trie current = root;
            for(int j=31; j>=0; j--) {
                int bit = 0;
                if(((1<<j)&nums[i])!=0)
                    bit = 1;
                if(bit==0) {
                    if(current.left==null)
                        current.left = new Trie(0);
                    current = current.left;
                }
                else{
                    if(current.right==null)
                        current.right = new Trie(1);
                    current = current.right;
                }
            }
        }
        
        int[] result = new int[queries.length];
        int[] bits = new int[32];
        int[] limitbits = new int[32];
        for(int i=0; i<queries.length; i++) {
            int xi = queries[i][0];
            int limit = queries[i][1];
            if(limit<nums[0])
                result[i] = -1;
            else{
                binary(~xi, bits);
                binary(limit, limitbits);
                int[] flag = findMaxValue(root, limitbits, bits, 31, 0, false, xi);
                result[i] = flag[0] ^ xi;
            }   
        }
        
        return result;
    }
}
