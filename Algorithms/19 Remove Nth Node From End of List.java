/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //if(head.next==null) return null;
        ListNode temp = new ListNode(-1);
        temp.next=head;
        head=temp;
        ListNode delay = head;
        ListNode current = head;
        for(int i=0; i<n; i++) current=current.next;
        
        while(current.next!=null){
            delay=delay.next;
            current=current.next;
        }
        delay.next=delay.next.next;
        return head.next;
    }
}