class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int row = intervals.length;
        int[] output = new int[row];
        // HashMap<Integer,Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int l = 0; l < row; l++) {
            map.put(intervals[l][0], l);
        }

        for (int i = 0; i < row ; i++) {
            int end = intervals[i][1];
            Integer nextStart = map.ceilingKey(end); // fast lookup

            if (nextStart == null) {
                output[i] = -1;
            } else {
                output[i] = map.get(nextStart);
            }
        }

        // for(int i = 0 ; i < intervals.length ; i++){
        //     int end = intervals[i][1];
        //     int index = -1;
        //     int min_start = Integer.MAX_VALUE;
        //     for(int j = 0 ; j < map.size() ; j++){
        //         int start = map.get(j);
        //         if(start >= end && start < min_start){
        //             min_start = start;
        //             index = j;
        //         }
        //     }
        //     output[i] = index;
        // }
        return output;
    }
}