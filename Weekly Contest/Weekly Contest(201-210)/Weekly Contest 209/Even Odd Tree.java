// 1609. Even Odd Tree
// difficulty: medium
// website: https://leetcode.com/contest/weekly-contest-209/problems/even-odd-tree/
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if(root==null)
            return true;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        int level=0;
        while(queue.size()>0) {
            TreeNode t1=queue.poll();
            int currSize=queue.size();
            if(t1.left!=null)
                queue.offer(t1.left);
            if(t1.right!=null)
                queue.offer(t1.right);
            if(level%2==0 && t1.val%2==0 || level%2==1 && t1.val%2==1)
                return false;
            while(currSize-->0) {
                TreeNode t2=queue.poll();
                if(level%2==0 && (t1.val>=t2.val || t2.val%2==0) || level%2==1 && (t1.val<=t2.val || t2.val%2==1))
                    return false;
                if(t2.left!=null)
                    queue.offer(t2.left);
                if(t2.right!=null)
                    queue.offer(t2.right);
                t1=t2;
            }
            ++level;
        }
        
        return true;
    }
}
