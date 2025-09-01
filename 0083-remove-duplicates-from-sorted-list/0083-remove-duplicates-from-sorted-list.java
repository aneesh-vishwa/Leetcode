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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1000);
        ListNode left = dummy;
        ListNode right = head;
        // left.next = right;

        while(right != null){
            while(right.next != null && right.val == right.next.val){
                right = right.next;
            }
            left.next = right;
            left = right;
            if(right.next == null){
                break;
            }
            else{
                right = right.next;
            }
        }
        return dummy.next;
    }
}