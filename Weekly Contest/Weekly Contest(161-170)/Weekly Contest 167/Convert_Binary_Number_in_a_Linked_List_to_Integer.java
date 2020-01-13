/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while(head!=null){
            result = result*2 + head.val;
            head = head.next;
        }
        return result;
    }
}
