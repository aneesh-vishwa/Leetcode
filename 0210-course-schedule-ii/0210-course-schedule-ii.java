class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // converting the matrix into adj list (directed graph)

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        int n = prerequisites.length;
        for (int i = 0; i < n; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
        }

        // topo sort
        int[] output = new int[numCourses];
        // ArrayList<Integer> output = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] in_degree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int inside_node : adj.get(i)) {
                in_degree[inside_node]++;
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (in_degree[i] == 0) {
                queue.add(i);
            }
        }
        int k = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int it : adj.get(node)) {
                in_degree[it]--;
                if (in_degree[it] == 0) {
                    queue.add(it);
                }
            }
            output[k] = node;
            k++;
        }
        if (k != numCourses) {
            return new int[0];
        }
        return output;
    }
}