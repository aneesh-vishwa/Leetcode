class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] prize = {"Gold Medal" , "Silver Medal","Bronze Medal"};
        String[] output = new String[n];
        HashMap<Integer , Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0 ; i < n ; i++){
            map.put(score[i] , i);
            pq.add(score[i]);
        }

        int rank = 1;
        while(!pq.isEmpty()){
            int current = pq.poll();
            int index = map.get(current);
            if(rank <= 3){
                output[index] = prize[rank - 1];
            }
            else{
                output[index] = String.valueOf(rank);
            }
            rank++;
        }
        return output;
    }
}