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
    public TreeNode createBinaryTree(int[][] descriptions) {
        int n = descriptions.length;
        HashMap<Integer , ArrayList<int[]>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            int key = descriptions[i][0];
            // int[] arr = ;
            if(!map.containsKey(key)){
                map.put(key , new ArrayList<>());
            }
            map.get(key).add(new int[]{descriptions[i][1] , descriptions[i][2]});
        }

        // Stack<Integer> parent_st = new Stack<>();
        Stack<TreeNode> parent_node_st = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < n ; i++){
            set.add(descriptions[i][1]);
        }
        Integer parent_value = null;

        for(int i = 0 ; i < n ; i++){
            if(!set.contains(descriptions[i][0])){
                parent_value = descriptions[i][0];
                break;
            }
        }
        if(parent_value == null){
            return null;
        }

        TreeNode root = new TreeNode(parent_value);
        
        parent_node_st.push(root);

        // parent_st.push(parent_value);

        while(!parent_node_st.isEmpty()){
            TreeNode current_parent_node = parent_node_st.pop();
            int current_parent = current_parent_node.val;
            ArrayList<int[]> next_parent = map.get(current_parent);
            if(next_parent == null){
                continue;
            }
            for(int i = 0 ; i < next_parent.size() ; i++){
                int value = next_parent.get(i)[0];
                int side = next_parent.get(i)[1];
                TreeNode child = new TreeNode(value);
                parent_node_st.push(child);
                if(side == 1){
                    current_parent_node.left = child;
                }
                else{
                    current_parent_node.right = child;
                }
                // parent_st.push(next_parent.get(i)[0]);
            }

        }
        return root;

    }
}