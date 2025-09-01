class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(); // key -> remainder and value -> freq
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            int remainder = sum % k;

            // Handle negative mod in Java
            if (remainder < 0) {
                remainder += k;
            }

            count += map.getOrDefault(remainder, 0);
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
