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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode current = head;
        int counter = 0;
        ListNode last = head;
        while(current != null){
            counter++;
            current = current.next;
            if(last.next != null){
                last = last.next;
            }
        }
        
        int l = k % counter;
        if(k == 0 || k == counter || l == 0){
            return head;
        }
        int pos = counter - l;
        int count = 1;
        current = head;
        while(current != null && count < pos){
            current = current.next;
            count++;
        }
        ListNode newhead = current.next;
        current.next = null;
        last.next = head;
        return newhead;
    }
}