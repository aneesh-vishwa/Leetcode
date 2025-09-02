class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            int[] A = points[i];
            for(int j = 0 ; j < n ; j++){
                int[] B = points[j];
                if(i == j || A[0] > B[0] || A[1] < B[1]){
                    continue;
                }

                boolean has_point = false;

                for(int k = 0 ; k < n ; k++){
                    int[] is_there_point = points[k];
                    if(k == i || k == j){
                        continue;
                    }
                    int x = is_there_point[0];
                    int y = is_there_point[1];

                    
                    // x <= Math.max(A[0] , B[0]) && y <= Math.max(A[1] , B[1])

                    if(x >= A[0] && x <= B[0] && y <= A[1] && y >= B[1]){
                        has_point = true;
                        break;
                    }
                }
                if(!has_point){
                    count++;
                }
            }
        }
        return count;
    }
    
}