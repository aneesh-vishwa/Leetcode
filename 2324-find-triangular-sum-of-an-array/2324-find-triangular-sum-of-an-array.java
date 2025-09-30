class Solution {
    public int triangularSum(int[] nums) {
        int size = nums.length;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < size ; i++) {
            queue.offer(nums[i]);
        }

        
        while (size > 1) {
            int prev = queue.poll();
            for (int i = 1; i < size; i++) {
                int curr = queue.poll();
                queue.offer((prev + curr) % 10);
                prev = curr;
            }
            size--;
        }
        return queue.poll();
    }
}