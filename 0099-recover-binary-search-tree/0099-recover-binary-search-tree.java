/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void inorder(TreeNode root , ArrayList<TreeNode> inorder_list){
        if(root == null){
            return;
        }
        inorder(root.left , inorder_list);
        inorder_list.add(root);
        inorder(root.right , inorder_list);

    }
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> inorder_list = new ArrayList<>();
        inorder(root , inorder_list);
        

        TreeNode first = null, second = null;

        for (int i = 0; i < inorder_list.size() - 1; i++) {
            if (inorder_list.get(i).val > inorder_list.get(i + 1).val) {
                if (first == null) {
                    first = inorder_list.get(i);
                }
                second = inorder_list.get(i + 1);
            }
        }

        // Swap the values
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}