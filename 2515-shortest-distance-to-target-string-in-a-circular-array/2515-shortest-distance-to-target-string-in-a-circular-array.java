class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){
            if(words[i].equals(target)){
                int distance_to_target = Math.abs(i - startIndex);
                int distance_to_target_rev = n - distance_to_target;
                min = Math.min(min , Math.min(distance_to_target , distance_to_target_rev));
            }
        }
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
        
    }
}