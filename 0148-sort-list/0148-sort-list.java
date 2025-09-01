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
    public ListNode sortList(ListNode head) {
        ListNode current = head;
        int counter = 0;
        while(current != null){
            counter++;
            current = current.next;
        }
        int[] nums = new int[counter];
        ListNode temp = head;
        for(int i=0;i<counter;i++){
            nums[i] = temp.val;
            temp = temp.next;
        }
        current = head;
        Arrays.sort(nums);
        for(int i=0;i<counter;i++){
            current.val = nums[i];
            current = current.next;
        }
        return head;
    }
}