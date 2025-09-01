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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        TreeNode insert = new TreeNode(val);
        if(node == null){
            return insert;
        }
        while (node != null) {
            if (val > node.val) {
                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = insert;
                    break;
                }

            }
            if (val < node.val) {
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = insert;
                    break;
                }
            }
        }
        return root;
    }
}