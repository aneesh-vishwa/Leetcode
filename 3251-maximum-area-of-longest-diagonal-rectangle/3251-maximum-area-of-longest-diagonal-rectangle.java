class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int m = dimensions.length;
        double start_dia = Math.sqrt(Math.pow(dimensions[0][0] , 2) + Math.pow(dimensions[0][1] , 2));
        int area = dimensions[0][0] * dimensions[0][1];

        for(int i = 1 ; i < m ; i++){
            int len = dimensions[i][0];
            int bre = dimensions[i][1];

            double dia_len = Math.sqrt(Math.pow(len , 2) + Math.pow(bre , 2));
            int curr_area = len * bre;

            if (dia_len > start_dia || (dia_len == start_dia && curr_area > area)) {
                start_dia = dia_len;
                area = curr_area;
            }
        }
        return area;
    }
}