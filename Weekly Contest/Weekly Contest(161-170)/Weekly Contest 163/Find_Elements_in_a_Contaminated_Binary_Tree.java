/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
    Set<Integer> set;
    void init(TreeNode node, int value){
        if(node==null) return;
        node.val=value;
        set.add(value);
        init(node.left, (value<<1)+1);
        init(node.right, (value<<1)+2);
    }
    
    public FindElements(TreeNode root) {
        set=new HashSet<Integer>();
        init(root, 0);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
    
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
