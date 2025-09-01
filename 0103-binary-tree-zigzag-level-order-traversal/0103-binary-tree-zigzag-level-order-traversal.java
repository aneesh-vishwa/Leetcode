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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }

        int flag = 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        
        while (!queue.isEmpty()) {
            int length_of_queue = queue.size(); // level of the tree
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < length_of_queue; i++) {
                

                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if(flag == 0){
                output.add(list);
                flag++;
            }
            else{
                ArrayList<Integer> rev_list = new ArrayList<>();
                int n = list.size();
                for(int i = n-1;i>=0;i--){
                    rev_list.add(list.get(i));
                }
                // Collections.reverse(list);
                output.add(rev_list);
                flag--;
            }
        }
        return output;

    }
}