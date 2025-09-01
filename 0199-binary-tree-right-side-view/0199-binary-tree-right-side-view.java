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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> output = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return output;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            int length_queue = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < length_queue; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            output.add(list.get(length_queue - 1));

        }
        return output;
    }
}