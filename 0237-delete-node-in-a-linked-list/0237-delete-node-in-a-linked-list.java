/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // ListNode current = head;
        // if(head.val == node.val){
        //     head = head.next;
        //     return head;
        // }
        // current = current.next;
        // ListNode temp = head;
        // while(current.val != node.val){
        //     current = current.next;
        //     temp = temp.next;
        // }
        // temp.next = temp.next.next;
        // return head;

        // Copy the value of the next node to the current node
        node.val = node.next.val;

        // Remove the next node from the linked list
        node.next = node.next.next;
    }
}