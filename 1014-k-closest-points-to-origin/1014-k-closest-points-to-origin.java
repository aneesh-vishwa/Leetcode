class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(a[2], b[2]));

        for (int[] point : points) {
            double x = point[0];
            double y = point[1];
            double dist = x * x + y * y;
            pq.offer(new Double[]{x, y, dist});
        }

        int[][] output = new int[k][2];
        for (int i = 0; i < k; i++) {
            Double[] current = pq.poll();
            output[i][0] = (int)(double)current[0];
            output[i][1] = (int)(double)current[1];
        }

        return output;
    }
}