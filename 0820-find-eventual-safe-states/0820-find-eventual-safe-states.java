class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // in this directed graph reverse the edges and perform the in_degree topo sort
        int n =  graph.length;
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i = 0 ; i < n ; i++){
            revAdj.add(new ArrayList<Integer>());
        }

        // for(int i = 0 ; i < n ; i++){    this method can not be used for revAdj
        //     int u = graph[i][0];
        //     int v = graph[i][1];
        //     revAdj.get(v).add(u);
        // }
        for(int i = 0 ; i < n ; i++){
            for(int it : graph[i]){
                revAdj.get(it).add(i);
            }
        }
       

        int[] in_degree = new int[n];
        for(int i = 0 ; i < n ; i++){
            for(int inside_node : revAdj.get(i)){
                in_degree[inside_node]++;
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(in_degree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.peek();
            output.add(node);
            queue.remove();
            for(int it : revAdj.get(node)){
                in_degree[it]--;
                if(in_degree[it] == 0){
                    queue.add(it);
                }
            }
            
        }
        Collections.sort(output);
        return output;
    }
}