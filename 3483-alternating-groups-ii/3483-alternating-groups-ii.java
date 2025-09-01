class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        // int n = colors.length;
        // int left = 0;
        // int right = (k-1) % n;
        // int count = 0;//count is set to limit iterartions so that loop will not run infinitely
        // int output = 0;
        // while(count < n){
        //     boolean is_alternating = true;
        //     for(int i = left; i != right; i = (i + 1) % n){
        //         if(colors[i] == colors[(i+1) % n]){
        //             is_alternating = false;
        //             break;
        //         }
        //     }
        //     if(is_alternating){
        //         output++;
        //     }
        //     count++;
        //     left = (left + 1) % n;
        //     right = (right + 1) % n;
        // }
        // return output;







        int n = colors.length;
        int count = 0;
        int left = 0;
        
        for (int right = 0; right < n + k - 1; right++) {
            if (right > 0 && colors[right % n] == colors[(right - 1) % n]) {
                left = right;  
            }
            
            if (right - left + 1 >= k) {
                count++;  
            }
        }
        
        return count;
    }
}