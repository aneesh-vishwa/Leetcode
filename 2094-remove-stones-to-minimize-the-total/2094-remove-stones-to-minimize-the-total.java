class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = piles.length;
        for(int i = 0 ; i < n ; i++){
            pq.add(piles[i]);
        }
        for(int j = 0 ; j < k ; j++){
            int operation = pq.poll();
            operation = (int)Math.ceil(operation/2.0);
            pq.add(operation);
        }
        int result = 0;
        while(!pq.isEmpty()){
            result += pq.poll();
        }
        return result;
    }
}