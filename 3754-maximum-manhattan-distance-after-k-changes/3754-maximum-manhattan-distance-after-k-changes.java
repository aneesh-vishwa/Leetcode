class Solution {
    public int maxDistance(String s, int k) {
        int vertical = 0;   // 'N' = +1, 'S' = -1
        int horizontal = 0;  // 'E' = +1, 'W' = -1

        int max_distance = 0; 
        int total_steps = s.length();

        for(int step = 0 ; step < total_steps ; step++){
            
            if(s.charAt(step) == ('N')){
                vertical++;
            }
            else if(s.charAt(step) == 'S'){
                vertical--;
            }
            else if(s.charAt(step) == 'E'){
                horizontal++;
            }
            else if(s.charAt(step) == 'W'){
                horizontal--;
            }


            int current_manhattan_distance = Math.abs(vertical) + Math.abs(horizontal);

            // Try to improve the distance using up to 'k' modifications
            // Each change can help increase distance by at most 2
            int improved_manhattan_distance = current_manhattan_distance + k * 2;

            // But we cannot exceed the total number of steps taken so far
            // Because you can't move farther than how many times you've moved
            int stepsTaken = step + 1;
            int capped_manhattan_distance = Math.min(improved_manhattan_distance, stepsTaken);

            // Update the answer with the best distance seen so far
            max_distance = Math.max(max_distance, capped_manhattan_distance);

            // max_distance = Math.max(max_distance , Math.min(Math.abs(vertical) + Math.abs(horizontal) + 2*k , i+1));
        }
        return max_distance;
    }
}