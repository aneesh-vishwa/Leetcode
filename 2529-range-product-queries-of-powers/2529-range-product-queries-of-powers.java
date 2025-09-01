class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int len = queries.length;
        int[] ans = new int[len];
        final int MOD = 1_000_000_007;
        List<Integer> powers = new ArrayList<>();
        
        while (n > 0) {
            int p = 1;
            while (p * 2 <= n) {
                p *= 2;
            }
            powers.add(p);
            n -= p;
        }
        
        Collections.sort(powers);

        int k = 0;
        for(int[] it : queries){
            int left = it[0];
            int right = it[1];

            long res = 1;

            for(int i = left ; i <= right ; i++){
                res = (res * powers.get(i)) % MOD;
            }

            ans[k] = (int) res;
            k++;
        }
        return ans;
    }
}