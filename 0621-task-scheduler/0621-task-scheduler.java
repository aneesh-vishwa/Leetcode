class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> b - a);

        for(int i = 0 ; i < tasks.length ; i++){
            freq[tasks[i] - 'A']++;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] > 0){
                pq.add(freq[i]);
            }
        }
        int total_time = 0;

        while(!pq.isEmpty()){
            int cycle = 1 + n;
            int completed_tasks = 0;
            ArrayList<Integer> remaining_tasks = new ArrayList<>();
            while(cycle > 0 && !pq.isEmpty()){
                int current_freq = pq.poll();
                if(current_freq > 1){
                    remaining_tasks.add(current_freq - 1);
                }
                completed_tasks++;
                cycle--;
            }
            for(int rem_task : remaining_tasks){
                pq.add(rem_task);
            }

            if(pq.isEmpty()){
                total_time += completed_tasks;
            }
            else{
                total_time += (1 + n);
            }
        }
        return total_time;
    }
}