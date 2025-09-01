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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        ArrayList<Integer> list = new ArrayList<>();

        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        int n = list.size();
        int mul = 1;
        int sum = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            if(list.get(i) == 0){
                mul *= 2;
                continue;
            }
            sum += list.get(i)*mul;
            mul *= 2;
        }
        return sum;
    }
}