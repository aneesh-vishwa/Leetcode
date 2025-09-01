class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        HashSet<Integer> set = new HashSet<>();

        int n = arr.length;

        for(int i = 1 ; i < n - 1 ; i++){
            if(arr[i - 1] == arr[i] && arr[i] == arr[i + 1]){
                set.add(i - 1);
            }
        }

        for(int j = 0 ; j < n ; j++){
            if(!set.contains(j)){
                sb.append(arr[j]);
            }
        }

        return sb.toString();
    }
}