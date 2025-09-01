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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int counter = 0;
        ListNode current = head;
        while(current != null){
            counter++;
            current = current.next;
        }
        int k = counter - n + 1;
        if(k == 1){
            head = head.next;
            return head;
        }
        ListNode temp = head;
        int count = 1;
        while(temp != null && count < k-1){
            temp = temp.next;
            count++;
        }
        if(temp.next.next == null){
            temp.next = null;
        }
        else{
            temp.next = temp.next.next;
        }
        return head;
    }
}