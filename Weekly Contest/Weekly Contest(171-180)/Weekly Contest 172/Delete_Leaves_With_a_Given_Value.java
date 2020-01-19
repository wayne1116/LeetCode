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
    TreeNode solv(TreeNode node, int target){
        if(node==null) return null;
        node.left=solv(node.left, target);
        node.right=solv(node.right, target);
        if(node.val==target && node.left==null && node.right==null)
            return null;
        return node;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        root=solv(root, target);
        return root;
    }
}
