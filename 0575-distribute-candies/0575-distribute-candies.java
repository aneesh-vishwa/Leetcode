class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        int n = candyType.length;

        for(int i = 0 ; i < n ; i++){
            set.add(candyType[i]);
        }
        int no_of_diff_candy = set.size();
        return Math.min(no_of_diff_candy , n/2);
    }
}