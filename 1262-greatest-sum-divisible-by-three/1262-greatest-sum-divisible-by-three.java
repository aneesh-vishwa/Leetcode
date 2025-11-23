class Solution {
    public int maxSumDivThree(int[] nums) {
        PriorityQueue<Integer> remainder_1 = new PriorityQueue<>();
        PriorityQueue<Integer> remainder_2 = new PriorityQueue<>();
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (num % 3 == 1) {
                remainder_1.add(num);
            } else if (num % 3 == 2) {
                remainder_2.add(num);
            }
        }

        if (sum % 3 == 0) {
            return sum;
        }

        int remove = Integer.MAX_VALUE;

        if (sum % 3 == 1) {
            if (!remainder_1.isEmpty()) {
                remove = Math.min(remove, remainder_1.peek());
            }
            if (remainder_2.size() >= 2) {
                int a = remainder_2.poll();
                int b = remainder_2.poll();
                remove = Math.min(remove, a + b);
            }
        } else {
            if (!remainder_2.isEmpty()) {
                remove = Math.min(remove, remainder_2.peek());
            }
            if (remainder_1.size() >= 2) {
                int a = remainder_1.poll();
                int b = remainder_1.poll();
                remove = Math.min(remove, a + b);
            }
        }

        if (remove == Integer.MAX_VALUE) {
            return 0;
        } else {
            return sum - remove;
        }
    }
}
