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
    public int pairSum(ListNode head) {
        //reverse the second half
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode back = null;
        ListNode current = slow.next;
        while(current != null){
            ListNode front = current.next;
            current.next = back;
            back = current;
            current = front;
        }
        ListNode left = head;
        ListNode right = back;
        int max_sum = 0;
        while(left != null && right != null){
            int sum = left.val + right.val;
            max_sum = Math.max(max_sum , sum);
            left = left.next;
            right = right.next;
        }
        return max_sum;
    }
}