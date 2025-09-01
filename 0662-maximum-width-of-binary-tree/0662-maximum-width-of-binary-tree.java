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
 class Pair{
    int index;
    TreeNode node;
    public Pair(int index, TreeNode node){
        this.index = index;
        this.node = node;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        if(root == null){return 0;}
        int width = 0;
        queue.add(new Pair(0,root));

        while(!queue.isEmpty()){
            int size = queue.size();
            int min_index = queue.peek().index;
            int first = -1;
            int last = -1;

            for(int i = 0; i < size; i++){
                Pair pair = queue.poll();
                int current_index = pair.index - min_index;
                TreeNode node = pair.node;
                if(i == 0){
                    first = current_index;
                }
                if(i == size - 1){
                    last = current_index;
                }

                if(node.left != null){
                    queue.add(new Pair(2*current_index+1, node.left));
                }
                if(node.right != null){
                    queue.add(new Pair(2*current_index+2, node.right));
                }
                
            }
            width = Math.max(width, last - first + 1);
        }
        return width;
    }
}