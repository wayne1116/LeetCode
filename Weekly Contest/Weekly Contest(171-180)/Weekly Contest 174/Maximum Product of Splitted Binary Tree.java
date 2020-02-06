/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    long result=0;
    long mod=1000000007;
    long traverse(TreeNode cur){
        if(cur==null) return 0;
        return traverse(cur.left)+traverse(cur.right)+cur.val;
    }
    long solv(TreeNode cur, long total){
        if(cur==null) return 0;
        long leftv=solv(cur.left, total);
        long rightv=solv(cur.right, total);
        result=Math.max(result, (total-leftv)*leftv);
        result=Math.max(result, (total-rightv)*rightv);
        return (leftv+rightv+cur.val);
    }
    public int maxProduct(TreeNode root) {
        long total=traverse(root);
        solv(root, total);
        return (int)(result%mod);
    }
}
