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
    public ListNode partition(ListNode head, int x) {
        ListNode greater = new ListNode(1000);
        ListNode temp = greater;
        ListNode smaller = new ListNode(1001);
        ListNode temp_small = smaller;

        ListNode current = head;

        while(current != null){
            if(current.val < x){
                smaller.next = current;
                current = current.next;
                smaller = smaller.next;
                smaller.next = null;
            }
            else{
                greater.next = current;
                current = current.next;
                greater = greater.next;
                greater.next = null;
            }
            
        }
        smaller.next = temp.next;
        return temp_small.next;
    }
}