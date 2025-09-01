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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        find_path(root , targetSum , output , path);
        return output;
    }
    public void find_path(TreeNode node, int targetSum , List<List<Integer>> output , List<Integer> path){
        if(node == null)return;
        
        path.add(node.val);
        targetSum -= node.val;
        if(node.left == null && node.right == null){
            if(targetSum == 0){
                output.add(new ArrayList<>(path));
            }
        }
        find_path(node.left , targetSum , output , path);
        
        find_path(node.right , targetSum , output , path);

        path.remove(path.size() - 1);

        
    }
}