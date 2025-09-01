class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                int left = root - 1;       // Nodes in left subtree
                int right = nodes - root;  // Nodes in right subtree
                dp[nodes] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }
}