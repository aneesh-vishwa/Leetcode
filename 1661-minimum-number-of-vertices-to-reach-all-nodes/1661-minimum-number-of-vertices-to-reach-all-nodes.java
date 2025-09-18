class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> output = new ArrayList<>();
        int[] in_degree = new int[n];
        for(List<Integer> edge : edges){
            in_degree[edge.get(1)]++;
        }

        for(int node = 0 ; node < n ; node++){
            if(in_degree[node] == 0){
                output.add(node);
            }
        }
        return output;
    }
}