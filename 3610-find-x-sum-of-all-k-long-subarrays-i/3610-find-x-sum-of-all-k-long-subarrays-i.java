class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int left = 0;
        int right = k;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = left; i < right; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] output = new int[n - k + 1];
        int index = 0;

        while (right <= n) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                if (map.get(a).equals(map.get(b))) {
                    return b - a;
                }
                return map.get(b) - map.get(a);
            });

            for (int num : map.keySet()) {
                pq.add(num);
            }

            int sum = 0;
            ArrayList<Integer> temp = new ArrayList<>();

            for (int i = 0; i < x && !pq.isEmpty(); i++) {
                int val = pq.poll();
                sum += val * map.get(val);
                temp.add(val);
            }

            for (int val : temp) {
                pq.add(val);
            }

            output[index++] = sum;

            if (right < n) {
                int out = nums[left];
                map.put(out, map.get(out) - 1);
                if (map.get(out) == 0) {
                    map.remove(out);
                }

                int in = nums[right];
                map.put(in, map.getOrDefault(in, 0) + 1);
            }

            left++;
            right++;
        }

        return output;
    }
}
