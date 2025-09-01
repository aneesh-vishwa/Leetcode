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
    public ListNode middleNode(ListNode head) {
        // ListNode current = head;
        // int counter = 0;
        // int mid = 0;
        // while(current != null){
        //     current = current.next;
        //     counter++;
        // }
        // if(counter%2 == 0){
        //     mid = counter/2 + 1;
        // }
        // if(counter%2 != 0){
        //     mid = (counter + 1)/2;
        // }
        // ListNode temp = head;
        // int count = 1;
        // while(temp != null && count < mid){
        //     temp = temp.next;
        //     count++;
        // }

        // return temp;

        // optimal approach 
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}