/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode node_l = queue.poll();
            TreeNode node_r = queue.poll();

            if (node_l == null && node_r == null) {
                continue;
            }

            if (node_l == null || node_r == null || node_l.val != node_r.val) {
                return false;
            }

            queue.add(node_l.left);
            queue.add(node_r.right);
            queue.add(node_l.right);
            queue.add(node_r.left);
        }

        return true;
    }
}