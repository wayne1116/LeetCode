/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode current=head;
        ListNode next=null;
        ListNode prev=null;
        
        if(current!=null){
            if(current.next!=null){
                next=current.next;
                current.next=next.next;
                next.next=current;
                prev=current;
                current=current.next;
                head=next;
            }
        }
        while(current!=null){
            if(current.next!=null){
                next=current.next;
                current.next=next.next;
                next.next=current;
                prev.next=next;
                prev=current;
            }
            current=current.next;
        }
        return head;
    }
}