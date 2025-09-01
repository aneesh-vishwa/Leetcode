class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] color, int col, int node) {
        if (color[node] != -1) {
            return color[node] == col; // If already colored, check if it matches the expected color
        }
        color[node] = col;
        for (int it : adj.get(node)) {
            if (!dfs(adj, color, 1 - col, it)) { 
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        int[] color = new int[m];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            adj.add(new ArrayList<>());
            color[i] = -1;

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            if (color[i] == -1) {
                if (dfs(adj, color, 0, i) == false) {
                    return false;
                }
            }
        }
        return true;
    }
}