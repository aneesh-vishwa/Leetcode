class Solution {
    public int minimumRecolors(String blocks, int k) {
        char[] charArray = blocks.toCharArray();
        int left = 0;
        int right = k-1;
        int min_count_W = Integer.MAX_VALUE;
        while(right < charArray.length){
            int count_W = 0;
            for(int i = left; i <= right ; i++){
                if(charArray[i] == 'W'){
                    count_W++;
                }
                
            }
            min_count_W = Math.min(min_count_W,count_W);
            left++;
            right++;
        }
        return min_count_W;
    }
}