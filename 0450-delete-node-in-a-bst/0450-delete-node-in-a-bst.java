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
    public static TreeNode find_last_right_LST(TreeNode node){
        if(node.right == null){
            return node;
        }
        return find_last_right_LST(node.right);
    }
    public static TreeNode delete(TreeNode node){
        if(node.left == null){
            return node.right;
        }
        else if(node.right == null){
            return node.left;
        }
        else{
            TreeNode rightchild = node.right;
            TreeNode lastRightOfLST = find_last_right_LST(node.left);
            lastRightOfLST.right = rightchild;
            return node.left;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null){
            return root;
        }

        if (root.val == key) {
            return delete(root);
        }

        TreeNode node = root;
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = delete(root.left);
                }
                root = root.left;
            }
             else {
                if (root.right != null && root.right.val == key) {
                    root.right = delete(root.right);
                }
                root = root.right;
            }
        }
        return node;
    }
}