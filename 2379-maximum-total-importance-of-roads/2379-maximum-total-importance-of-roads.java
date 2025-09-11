class Solution {
    public long maximumImportance(int n, int[][] roads) {
        //freq map for the cities
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int[] it : roads){
            int first = it[0];
            int second = it[1];
            map.put(first , map.getOrDefault(first , 0) + 1);
            map.put(second , map.getOrDefault(second , 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> b[1] - a[1]);

        for(int i = 0 ; i < n ; i++){
            int freq = map.getOrDefault(i, 0);
            pq.offer(new int[]{i , freq});
        }
        int[] weight_arr = new int[n];
        int weight = n;
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            weight_arr[current[0]] = weight;
            weight -= 1;
        }

        long  total_sum = 0;

        for(int[] it : roads){
            int first = it[0];
            int second = it[1];
            long  sum = (long)weight_arr[first] +weight_arr[second];
            total_sum += sum;
        }
        return total_sum;
    }
}