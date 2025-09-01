class Solution {
    public int tribonacci(int n) {
        int[] store = new int[38];

        store[0] = 0;
        store[1] = 1;
        store[2] = 1;

        int first = 0 ;
        int second = 1;
        int third = 2;

        while(third < n){
            store[third+1] = store[first] + store[second] + store[third];
            first++;
            second++;
            third++;
        }
        return store[n];
    }
}