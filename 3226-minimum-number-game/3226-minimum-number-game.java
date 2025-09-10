class Solution {
    public int[] numberGame(int[] nums) {
        int[] arr = new int[nums.length];
        int k = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> a - b);
        for(int i = 0 ; i < nums.length ; i++){
            pq.offer(nums[i]);
        }

        while(!pq.isEmpty()){
            int small = pq.poll();
            int second_small = pq.poll();
            arr[k] = second_small;
            arr[k+1] = small;
            k += 2;
        }
        return arr;
    }
}