class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas = 0;
        int total_cost = 0;

        for(int i = 0 ; i < gas.length ; i++){
            total_gas += gas[i];
        }
        for(int j = 0 ; j < cost.length ; j++){
            total_cost += cost[j];
        }

        if(total_cost > total_gas){
            return -1;
        }
        int current_gas = 0;
        int start_index = 0;
        for(int k = 0 ; k < gas.length ; k++){
            current_gas += gas[k] - cost[k];
            
            if(current_gas < 0){
                start_index = k + 1;
                current_gas = 0;
            }
        }
        return start_index;
    }
}