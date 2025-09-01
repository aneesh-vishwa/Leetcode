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
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head.next == null){
            head = null;
            return head;
        }
        // if(head.next.next == null){
        //     head = head.next;
        //     return head;
        // }
        while(fast != null && fast.next != null && fast.next.next != null && fast.next.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;

    }
}