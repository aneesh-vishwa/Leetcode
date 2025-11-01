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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
        }
    
        while(set.contains(head.val)){
            head = head.next;
        }
        ListNode current = head;

        while(current != null && current.next != null){
            if(set.contains(current.next.val)){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }
        return head;
    }
}