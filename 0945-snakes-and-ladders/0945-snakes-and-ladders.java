class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean left_to_right = true;
        int[] flat = new int[n * n + 1];
        int k = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (left_to_right) {
                for (int j = 0; j < n; j++) {
                    flat[k++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    flat[k++] = board[i][j];
                }
            }
            left_to_right = !left_to_right;
        }

        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int move = 1; move <= 6 && current + move <= n * n; move++) {
                int next = current + move;
                int dest;
                if (flat[next] == -1) {
                    dest = next;
                } else {
                    dest = flat[next];
                }

                if (dist[dest] == -1) {
                    dist[dest] = dist[current] + 1;
                    queue.offer(dest);
                }
            }
        }
        if(dist[n * n] > 0){
            return dist[n * n] - 1;
        }
        return dist[n * n];
    }
}