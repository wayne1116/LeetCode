/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    int[] fail;
    int[] number;
    boolean result;
    public boolean isSubPath(ListNode head, TreeNode root) {
        int count=0;
        ListNode current=head;
        while(current!=null) {
            current=current.next;
            ++count;
        }
        
        number=new int[count];
        current=head;
        for(int i=0; i<count; i++) {
            number[i]=head.val;
            head=head.next;
        }
        
        fail=new int[count];
        fail[0]=-1;
        for(int i=1; i<count; i++) {
            fail[i]=-1;
            int t=fail[i-1];
            while((number[i]!=number[t+1]) && (t>=0) ){
                t=fail[t];
            }
            
            if(number[i] == number[t+1]){
                fail[i] = t+1;
            }
        }
        
        result=false;
        solv(root, 0, count);
        return result;
    }
    
    void solv(TreeNode current, int start, int end) {
        if(start==end){
            result=true;
            return;
        }
        
        if(current==null)
            return;
        
        if(current.val==number[start]){
            ++start;
        }
        else{
            while(start>0){
                if(current.val==number[start])
                    break;
                start=fail[start-1]+1;
            }
            if(current.val==number[start])
                ++start;
        }
        
        solv(current.left, start, end);
        solv(current.right, start, end);
    }
}
