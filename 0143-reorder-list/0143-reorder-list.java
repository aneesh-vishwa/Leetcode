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
    public void reorderList(ListNode head) {
        //find the mid then reverse the second part then use two pointers

        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) { //getting the first mid;
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode end = fast;
        ListNode back = slow;
        ListNode current = slow.next;
        back.next = null;

        while (current != null) {
            ListNode front = current.next;
            current.next = back;
            back = current; 
            current = front; 
        }

        ListNode left = head;
        ListNode right = back;
        while (right.next != null) {
            ListNode tempLeft = left.next;
            ListNode tempRight = right.next;

            left.next = right;
            right.next = tempLeft;

            left = tempLeft;
            right = tempRight;
        }
    }
}