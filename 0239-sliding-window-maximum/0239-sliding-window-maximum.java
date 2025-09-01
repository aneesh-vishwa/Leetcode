// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         if (n == 1 || k == 1) return nums;

//         int[] output = new int[n - k + 1];
//         int max = Integer.MIN_VALUE;
//         int maxIndex = -1;

//         for (int i = 0; i <= n - k; i++) {
//             if (maxIndex >= i) {
//                 if (nums[i + k - 1] > max) {
//                     max = nums[i + k - 1];
//                     maxIndex = i + k - 1;
//                 }
//             } else {
//                 max = nums[i];
//                 maxIndex = i;
//                 for (int j = i + 1; j < i + k; j++) {
//                     if (nums[j] > max) {
//                         max = nums[j];
//                         maxIndex = j;
//                     }
//                 }
//             }
//             output[i] = max;
//         }
//         return output;
//     }
// }







class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove elements out of this window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element index
            deque.offerLast(i);

            // Window is valid, save max (from deque front)
            if (i >= k - 1) {
                output[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return output;
    }
}
