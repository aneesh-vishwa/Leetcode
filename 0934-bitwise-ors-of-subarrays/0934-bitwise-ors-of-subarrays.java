class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> ans = new HashSet<>();
        HashSet<Integer> cur = new HashSet<>(); //Stores all possible bitwise ORs of subarrays ending at the previous element.

        cur.add(0);

        for(int x : arr){
            HashSet<Integer> cur2 = new HashSet<>();

            for(int y : cur){
                cur2.add(x|y);
            }
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }
        return ans.size();
    }
}