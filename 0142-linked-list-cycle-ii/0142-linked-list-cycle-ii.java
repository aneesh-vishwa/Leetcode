/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // HashMap<ListNode,Integer> map = new HashMap<>();
        // int value = -1;
        // ListNode current = head;
        // while(current != null){
        //     if(map.containsKey(current)){
        //         return current;
        //     }
        //     map.put(current,1);
        //     current = current.next;
        // }
        // return null;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow =  slow.next;
            fast =  fast.next.next;
            if(slow == fast){
                ListNode pos = head;
                while(pos != slow){
                    pos = pos.next;
                    slow = slow.next;
                }
                return pos;
            }
        }
        return null;
    }
}