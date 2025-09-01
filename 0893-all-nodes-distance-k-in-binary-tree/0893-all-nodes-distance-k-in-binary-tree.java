/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> output = new ArrayList<>();

        HashMap<TreeNode , TreeNode> parent_map = new HashMap<>();
        find_parent(root , parent_map);

        HashMap<TreeNode , Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(target);
        visited.put(target , true);

        int dist = 0;

        while(!queue.isEmpty()){
            if(dist == k){
                break;
            }
            dist++;
            int queue_size = queue.size();

            for(int i = 0 ; i < queue_size ; i++){
                TreeNode node = queue.poll();

                if(node.left != null && visited.get(node.left) == null){
                    queue.add(node.left);
                    visited.put(node.left , true);
                }

                if(node.right != null && visited.get(node.right) == null){
                    queue.add(node.right);
                    visited.put(node.right , true);
                }

                if(parent_map.get(node) != null && visited.get(parent_map.get(node)) == null){
                    queue.add(parent_map.get(node));
                    visited.put(parent_map.get(node) , true);
                }
            }
        }

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            output.add(temp.val);
        }

        return output;

    }
    public void find_parent(TreeNode root , HashMap<TreeNode , TreeNode> parent_map){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left != null){
                parent_map.put(current.left , current);
                queue.add(current.left);
            }
            if(current.right != null){
                parent_map.put(current.right , current);
                queue.add(current.right);
            }
        }
    }
}