class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxsum = 0;
        int left_sum = 0;

        for (int i = 0; i < k; i++) {
            left_sum += cardPoints[i];
        }

        int sum = left_sum;
        maxsum = sum;

        for (int i = n - 1; i >= n - k; i--) {
            sum = sum - cardPoints[k - (n - i)] + cardPoints[i];
            maxsum = Math.max(maxsum, sum);
        }

        return maxsum;
    }
}
