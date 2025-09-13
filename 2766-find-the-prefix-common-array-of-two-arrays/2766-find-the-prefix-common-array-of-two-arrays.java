class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        //make sure to look at the Constraints clearly
        int n = A.length;
        int[] freq = new int[n + 1];
        int[] arr = new int[n];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            freq[A[i]]++;
            if(freq[A[i]] == 2){
                count += 1;
            }
            freq[B[i]]++;
            if(freq[B[i]] == 2){
                count += 1;
            }
            arr[i] = count;

        }
        return arr;
    }
}