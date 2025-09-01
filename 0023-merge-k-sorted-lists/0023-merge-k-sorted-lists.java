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
class Pair {
    int node_val;
    ListNode node;

    Pair(int node_val, ListNode node) {
        this.node_val = node_val;
        this.node = node;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(((a, b) -> a.node_val - b.node_val));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(new Pair(lists[i].val, lists[i]));
            }
        }

        ListNode dummy_node = new ListNode(-1);
        ListNode temp = dummy_node;

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int value = pair.node_val;
            ListNode current = pair.node;
            temp.next = current;
            temp = temp.next;
            if (current.next != null) {
                pq.add(new Pair(current.next.val, current.next));
            }
        }
        return dummy_node.next;
    }
}