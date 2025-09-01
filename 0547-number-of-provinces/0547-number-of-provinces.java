// class Solution {
//     public static void dfs(int node,int[] visited_node,  ArrayList<ArrayList<Integer>> adj){
//         visited_node[node] = 1;
//         for(Integer i : adj.get(node)){
//             if(visited_node[i] == 0){
//                 visited_node[i] =1;
//                 dfs(i,visited_node,adj);
//             }
//         }
//     }

//     public int findCircleNum(int[][] isConnected) {
//         int count = 0;
//         // Queue<Integer> queue = new LinkedList<>();
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
//         int V = isConnected.length;
//         int column = isConnected[0].length;
//         for(int i = 0 ; i < V;i++){
//             adj.add(new ArrayList<Integer>());
//         }

//         for(int i = 0 ; i < V ; i++){
//             for(int j = 0 ; j < column ; j++){
//                 if(isConnected[i][j] == 1 && i != j){
//                     adj.get(i).add(j);
//                     adj.get(j).add(i);
//                 }                
//             }
//         }
//         int[] visited_node = new int[V + 1];
//         for(int i = 1 ; i <= V ; i++){
//             if(visited_node[i] == 0){
//                 count++;
//                 // visited_node[i] = 1;
//                 dfs(i,visited_node,adj);
//             }
            
//         }
//         return count;

//     }
// }


class Solution {
    public static void dfs(int node, int[] visited_node, ArrayList<ArrayList<Integer>> adj) {
        visited_node[node] = 1;
        for (Integer i : adj.get(node)) {
            if (visited_node[i] == 0) {
                dfs(i, visited_node, adj);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int V = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) { 
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) { 
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i + 1).add(j + 1); 
                    adj.get(j + 1).add(i + 1);
                }
            }
        }

        int[] visited_node = new int[V + 1];  
        for (int i = 1; i <= V; i++) {  
            if (visited_node[i] == 0) {
                count++;
                dfs(i, visited_node, adj);
            }
        }
        return count;
    }
}
