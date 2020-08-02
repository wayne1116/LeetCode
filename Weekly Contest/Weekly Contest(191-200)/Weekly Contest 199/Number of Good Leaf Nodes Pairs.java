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
    int result=0;
    public int countPairs(TreeNode root, int distance) {
        result=0;
        solv(root, distance);
        
        return result;
    }
    
    List<Integer> solv(TreeNode current, int distance) {
        if(current==null) return new ArrayList<Integer>();
        if(current.left==null && current.right==null){
            List<Integer> t=new ArrayList<Integer>();
            t.add(0);
            return t;
        }
        
        List<Integer> t1=solv(current.left, distance);
        List<Integer> t2=solv(current.right, distance);
        List<Integer> temp=new ArrayList<Integer>();
        
        for(int i=0; i<t1.size(); i++)
            temp.add(t1.get(i)+1);
        for(int i=0; i<t2.size(); i++)
            temp.add(t2.get(i)+1);
        
        for(int i=0; i<t1.size(); i++) {
            int dis1=t1.get(i);
            for(int j=0; j<t2.size(); j++) {
                int dis2=t2.get(j);
                if(dis1+dis2+2<=distance)
                    ++result;
            }
        }
  
        return temp;
    }
    
}
