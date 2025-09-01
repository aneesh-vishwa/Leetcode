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
    public ListNode reverse(ListNode rev_head){
        ListNode previous = null;
        ListNode current = rev_head;
        ListNode front = rev_head;

        while(current != null){
            front = current.next;
            current.next = previous;
            previous = current;
            current = front;
        }
        return previous;

    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null || head.next == null){
            return true;
        }
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second_head = reverse(slow.next);
        ListNode first = head;
        ListNode second = second_head;
        while(second != null){
            if(first.val != second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;







        // StringBuilder s = new StringBuilder();
        // ListNode current = head;
        // while(current != null){
        //     s.append(current.val);
        //     current = current.next;
        // }

        // String t = new StringBuilder(s).reverse().toString();


        // if(s.toString().equals(t)){
        //     return true;
        // }
        // return false;
        
    }
}