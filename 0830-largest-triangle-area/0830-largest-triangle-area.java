class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ans = 0;
        for(int i = 0 ; i < n - 2 ; i++){
            for(int j = i + 1 ; j < n - 1 ; j++){
                for(int k = j + 1 ; k < n ; k++){
                    int[] P = points[i];
                    int[] Q = points[j];
                    int[] R = points[k];
                    ans = Math.max(ans , 0.5*Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1]
                             -P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]));
                }
            }
        }
        return ans;
    }
}