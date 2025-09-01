class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        long current_ugly = 1;
        for(int i = 0 ; i < n - 1 ; i++){
            current_ugly = set.pollFirst();

            set.add(current_ugly*2);
            set.add(current_ugly*3);
            set.add(current_ugly*5);
        }
        long res = set.pollFirst();
        return (int)res;
    }
}