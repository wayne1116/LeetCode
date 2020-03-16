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
    List<Integer> sorted;
    int[] sorted1;
    public TreeNode balanceBST(TreeNode root) {
        if(root==null)
            return null;
        
        sorted=new ArrayList<Integer>();
        traverse(root);
        
        sorted1=new int[sorted.size()];
        for(int i=0; i<sorted.size(); i++)
            sorted1[i]=sorted.get(i);
        
        int total=sorted.size()>>1;
        TreeNode newroot=new TreeNode(sorted1[total]);
        newroot.left=constructTree(0, total-1);
        newroot.right=constructTree(total+1, sorted.size()-1);
        
        return newroot;
    }
    
    void traverse(TreeNode current) {
        if(current==null)
            return ;
        
        traverse(current.left);
        sorted.add(current.val);
        traverse(current.right);
    }
    
    TreeNode constructTree(int left, int right) {
        if(left>right)
            return null;
        
        int middle=(left+right)>>1;
        TreeNode current=new TreeNode(sorted1[middle]);
        current.left=constructTree(left, middle-1);
        current.right=constructTree(middle+1, right);
        
        return current;
    }
}
