class Solution {

    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        long[] ans = new long[n];
        for (List<Integer> current : map.values()) {
            long total = 0;
            for (int idx : current) {
                total += idx;
            }
            long prefixTotal = 0;
            int size = current.size();
            for (int i = 0; i < size; i++) {
                int idx = current.get(i);
                ans[idx] = total - prefixTotal * 2 + (long) idx * (2 * i - size);
                prefixTotal += idx;
            }
        }
        return ans;
    }
}