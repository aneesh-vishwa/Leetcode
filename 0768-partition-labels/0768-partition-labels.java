class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> output = new ArrayList<>();
        int[] first_occ = new int[26];
        int[] last_occ = new int[26];
        Arrays.fill(first_occ , -1);
        Arrays.fill(last_occ , -1);
        int count_inter = 0;

        char[] ch_arr = s.toCharArray();
        for(int i = 0 ; i < ch_arr.length ; i++){
            if(first_occ[ch_arr[i] - 'a'] == -1){
                first_occ[ch_arr[i] - 'a'] = i;
                count_inter++;
            }
        }
        for(int i = 0 ; i < ch_arr.length ; i++){
            last_occ[ch_arr[i] - 'a'] = i;
        }

        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0 ; i < 26 ; i++){
            if(first_occ[i] == - 1 || last_occ[i] == -1){
                continue;
            }
            list.add(new int[] {first_occ[i] , last_occ[i]});
        }

        Collections.sort(list , (a , b) -> a[0] - b[0]);

        int start = list.get(0)[0];
        int end = list.get(0)[1];
        for(int i = 1 ; i < list.size() ; i++){
            int curr_start = list.get(i)[0];
            int curr_end = list.get(i)[1];

            if(curr_start < end || curr_end < end){
                start = Math.min(start , curr_start);
                end = Math.max(end , curr_end);
            }
            else{
                output.add(end - start + 1);
                start = curr_start;
                end = curr_end;
            }
        }
        output.add(end - start + 1);
        return output;
    }
}