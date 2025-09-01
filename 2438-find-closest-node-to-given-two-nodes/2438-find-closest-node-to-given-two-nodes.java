class Solution {
    public int[] dfs(int node, int[] distance, int[] edges) {
        distance[node] = 0;
        int dist = 0;
        int neighbour = edges[node];

        while (neighbour != -1 && distance[neighbour] == Integer.MAX_VALUE) {
            dist++;
            distance[neighbour] = dist;
            node = neighbour;
            neighbour = edges[node];
        }

        return distance;
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        for (int i = 0; i < n; i++) {
            dist1[i] = Integer.MAX_VALUE;
            dist2[i] = Integer.MAX_VALUE;
        }

        dist1 = dfs(node1, dist1, edges);
        dist2 = dfs(node2, dist2, edges);

        int answer = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDistance) {
                    minDistance = maxDist;
                    answer = i;
                }
            }
        }

        return answer;
    }
}