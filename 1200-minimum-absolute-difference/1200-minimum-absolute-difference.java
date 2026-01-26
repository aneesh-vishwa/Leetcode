class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> output = new ArrayList<>();

        int min_possible_difference = Integer.MAX_VALUE;

        for(int i = 0 ; i < n - 1 ; i++){
            min_possible_difference = Math.min(min_possible_difference , arr[i + 1] - arr[i]);
        }
        int i = 0;

        while(i < n - 1){
            if(arr[i + 1 ] - arr[i] == min_possible_difference){
                output.add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
            }
            i++;
        }
        return output;
    }
}