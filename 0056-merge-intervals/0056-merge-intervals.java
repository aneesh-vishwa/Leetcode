class Solution {
    public int[][] merge(int[][] intervals) {
        int m = intervals.length; //no of rows
        // int i = 0;
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals , (a , b) -> a[0] - b[0]);
        int[] first = intervals[0];
        for(int[] i : intervals){
            int start = i[0];
            int end = i[1];

            // if(start <= first[1])

            if(start <= first[1]){
                first[0] = Math.min(first[0] , start);
                first[1] = Math.max(first[1] , end);
            }
            else{
                list.add(first);
                first = new int[]{start, end}; // create new
            }

            

        }
        list.add(first);
        int[][] result = new int[list.size()][];
        result = list.toArray(result);

        return result;
    }
}