/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0; 
        int temp1, temp2, tempsum;
        ListNode temp;
        
        while(l1!=null || l2!=null){
            temp1 = (l1!=null)?l1.val:0;
            temp2 = (l2!=null)?l2.val:0;
            
            tempsum = temp1+temp2+carry;
            carry = tempsum / 10;
            tempsum %=10;
            temp = new ListNode(tempsum);
            current.next=temp;
            current=temp;
            
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        if(carry==1){
            temp = new ListNode(1);
            current.next=temp;
            current=temp;
        }
        current.next=null;
        return result.next;
    }
}