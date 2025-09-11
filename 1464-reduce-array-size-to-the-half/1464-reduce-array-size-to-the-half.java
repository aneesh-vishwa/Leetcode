class Solution {
    public int minSetSize(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> b - a);
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;

        for(int it : arr){
            map.put(it , map.getOrDefault(it , 0) + 1);
        }

        for(int value : map.values()){
            pq.add(value);
        }
        int sum = 0;
        int count = 0;
        while(sum < n/2){
            sum += pq.poll();
            count++;
        }
        return count;
    }
}