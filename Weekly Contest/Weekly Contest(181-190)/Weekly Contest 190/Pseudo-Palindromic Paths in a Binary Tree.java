/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int mask;
    int result;
    public int pseudoPalindromicPaths (TreeNode root) {
        mask=0;
        result=0;
        solv(root);
        
        return result;
    }
    
    void solv(TreeNode current) {
        if(current==null)
            return ;
        if(current.left==null && current.right==null){
            mask^=(1<<current.val);
            if(mask==0)
                ++result;
            else{
                for(int i=1; i<10; i++){
                    if(((1<<i)^mask)==0){
                        ++result;
                        break;
                    }
                }   
            }
            mask^=(1<<current.val);
            return;
        }
        mask^=(1<<current.val);
        solv(current.left);
        solv(current.right);
        mask^=(1<<current.val);
    }
}
