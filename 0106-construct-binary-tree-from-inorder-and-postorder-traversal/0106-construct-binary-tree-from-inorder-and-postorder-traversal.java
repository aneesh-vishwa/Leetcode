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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = build_tree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);

        return root;
    }

    public TreeNode build_tree(int[] inorder, int inorder_start, int inorder_end, int[] postorder, int postorder_start,
            int postorder_end, HashMap<Integer, Integer> map) {

        if (postorder_start > postorder_end || inorder_start > inorder_end) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder_end]);

        int idx_of_root_in_inorder = map.get(postorder[postorder_end]);
        int left_subtree_size = idx_of_root_in_inorder - inorder_start;

        

        root.left = build_tree(inorder, inorder_start, idx_of_root_in_inorder - 1,
                postorder, postorder_start, postorder_start + left_subtree_size - 1, map);

        root.right = build_tree(inorder, idx_of_root_in_inorder + 1, inorder_end,
                postorder, postorder_start + left_subtree_size, postorder_end - 1, map);

        return root;
    }
}