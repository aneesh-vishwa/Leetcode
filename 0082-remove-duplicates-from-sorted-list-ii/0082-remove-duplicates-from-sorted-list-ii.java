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
        ListNode slow = dummy;
        ListNode fast = head;

        slow.next = fast;

        while(fast != null){
            while(fast.next != null && fast.val == fast.next.val){
                fast = fast.next;
            }
            if(slow.next != fast && fast.next != null){
                slow.next = fast.next;
                fast = slow.next;
            }
            else if(slow.next != fast && fast.next == null){
                slow.next = null;
                break;
            }
            else{
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}