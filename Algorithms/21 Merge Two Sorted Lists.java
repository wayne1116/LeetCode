/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current=result;
        int temp;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                temp=l1.val;
                l1=l1.next;
            }
            else{
                temp=l2.val;
                l2=l2.next;
            }
            current.next=new ListNode(temp);
            current=current.next;
        }
        while(l1!=null){
            current.next=new ListNode(l1.val);
            current=current.next;
            l1=l1.next;
        }
        while(l2!=null){
            current.next=new ListNode(l2.val);
            current=current.next;
            l2=l2.next;
        }
        current.next=null;
        return result.next;
    }
}