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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i < inorder.length; i++){
            map.put(inorder[i] , i);
        }

        // need to build the tree using this hashmap and the preorder

        // inputs of the following method are inorder array , start_index of inorder , end_index of inorder
        // preorder array , start_index of preorder , end_index of preorder and map 
        TreeNode root = build_tree(inorder , 0 , inorder.length - 1 , preorder , 0 , preorder.length - 1 , map);

        return root;
    }

    public TreeNode build_tree(int[] inorder , int inorder_start , int inorder_end ,
        int[] preorder , int preorder_start , int preorder_end , HashMap<Integer , Integer> map){
            if(preorder_start > preorder_end || inorder_start > inorder_end){
                return null;
            }
            TreeNode root = new TreeNode(preorder[preorder_start]);

            int root_in_inorder = map.get(preorder[preorder_start]);
            int left_nums = root_in_inorder - inorder_start;

            root.left = build_tree(inorder , inorder_start , root_in_inorder - 1 , preorder , preorder_start + 1 , preorder_start + left_nums , map);

            root.right = build_tree(inorder , root_in_inorder + 1 , inorder_end , preorder , preorder_start + left_nums + 1 , preorder_end , map);

            return root;
        }
}