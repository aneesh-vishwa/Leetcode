class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }
        // alternate way to convert mat to adj list

        // int m = prerequisites.length;
        // for(int i = 0 ; i < m ; i++){
        //     adj.get(prerequisites[i][0].add(prerequisites[i][1]));
        // }

        int[] in_degree = new int[numCourses];
        ArrayList<Integer> output = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0 ; i < numCourses ; i++){
            for(int inside_node : adj.get(i)){
                in_degree[inside_node]++;
            }
        }
        for(int i = 0 ; i < numCourses ; i++){
            if(in_degree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int it : adj.get(node)){
                in_degree[it]--;
                if(in_degree[it] == 0){
                    queue.add(it);
                }
            }
            output.add(node);
            
        }
        // chusu e output array is a topo sort array so topo sort lo anni vertices unte there is no cycle 
        if(output.size() == numCourses){//so ikkada anni vertices unte cycle undadhu so cycle ledhu kabatti we can return true
            return true;
        }
        return false;

    }
}