class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] output = new int[2];
        int m = aliceSizes.length;
        int n = bobSizes.length;

        int alice_sum = 0;
        int bob_sum = 0;
        for (int i = 0; i < m; i++) {
            alice_sum += aliceSizes[i];
        }
        for (int j = 0; j < n; j++) {
            bob_sum += bobSizes[j];
        }

        int delta = (bob_sum - alice_sum) / 2;
        Set<Integer> bobSet = new HashSet<>();
        for (int b : bobSizes){
            bobSet.add(b);
        }
            
        for (int a : aliceSizes) {
            if (bobSet.contains(a + delta)) {
                return new int[] { a, a + delta };
            }
        }
        return new int[0];
    }
}