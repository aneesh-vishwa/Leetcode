/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // ListNode current_A = headA;
        // ListNode current_B = headB;
        // if(headA == null || headB == null){
        // return null;
        // }
        // if(headA.next == null){
        // return headA;
        // }
        // if(headB.next == null){
        // return headB;
        // }

        // while(current_A != current_B){
        // current_A = current_A.next;
        // if(current_A.next == null && current_B.next != null){
        // current_B = current_B.next;
        // current_A = headA;
        // }
        // else if(current_B.next == null){
        // return null;
        // }
        // }
        // return current_A;

        ListNode c1 = headA;
        ListNode c2 = headB;
        while (c1 != null && c2 != null) {
            if (c1 == c2) {
                return c1;

            } else if (c1.next == null) {
                c1 = headB;
                c2 = c2.next;
            } else if (c2.next == null) {
                c2 = headA;
                c1 = c1.next;
            } else {
                c1 = c1.next;
                c2 = c2.next;
            }

        }
        return null;
    }
}