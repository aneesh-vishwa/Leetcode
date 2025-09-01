/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode c1 = l1;
        ListNode c2 = l2;
        int sum = 0;
        ListNode head = new ListNode(0);
        ListNode temp = head;

        while(c1 != null || c2 != null){
            sum = carry;
            if(c1 != null){
                sum += c1.val;
                c1 = c1.next;
            }
            if(c2 != null){
                sum += c2.val;
                c2 = c2.next;
            }
            temp.next = new ListNode(sum%10);
            temp = temp.next;

            carry = sum/10;
        }
        if(carry > 0){
            temp.next = new ListNode(carry);
        }
        return head.next;
    }
}