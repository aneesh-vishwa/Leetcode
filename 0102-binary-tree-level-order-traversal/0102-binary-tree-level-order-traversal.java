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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
         // ADD TREENODE TO QUEQE AND VALUES OF THAT NODE TO A LIST THEN THAT LIST TO OUTPUT LIST
        queue.add(root);
        while (!queue.isEmpty()) {
            int level_size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level_size; i++) {
                TreeNode node = queue.poll(); // Remove and store the node
                list.add(node.val); // Add the node's value to the listv

                if (node.left != null) {
                    queue.add(node.left);

                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            output.add(list);
        }
        return output;
    }
}