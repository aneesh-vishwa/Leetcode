class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        if(n == 1){
            result.add(0);
            return result;
        }

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        int m = edges.length;
        for(int i = 0 ; i < m ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] in_degree = new int[n];

        for(int i = 0 ; i < n ; i++){
            for(int it : adj.get(i)){
                in_degree[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(in_degree[i] == 1){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            result = new ArrayList<>();

            for(int i = 0 ; i < size ; i++){
                int node = queue.poll();
                result.add(node);
                for(int neighbour : adj.get(node)){
                    in_degree[neighbour]--;

                    if(in_degree[neighbour] == 1){
                        queue.add(neighbour);
                    }
                }
            }
        }
        return result;
    }
}