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
    int[] number;
    int count;
    void dfs(TreeNode curr){
        if(curr==null) return;
        number[count++]=curr.val;
        dfs(curr.left);
        dfs(curr.right);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result=new ArrayList<Integer>();
        number=new int[10000];
        count=0;
        dfs(root1);
        dfs(root2);
        Arrays.sort(number, 0, count);
        for(int i=0; i<count; i++) result.add(number[i]);
        return result;
    }
}
