class Solution {
    public int possibleStringCount(String word) {

        char[] arr = word.toCharArray();

        int n = arr.length;

        int count = 1;
        for(int left = n - 2 ; left >= 0 ; left--){
            if(arr[left] == arr[left+1]){
                count++;
            }
        }
        return count;
    }
}