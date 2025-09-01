class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        for(int i = 0 ; i < n ; i++){
            candies[i] = 1;
        }
        for(int j = 1 ; j < n ; j++){
            if(ratings[j] > ratings[j-1]){
                candies[j] = candies[j-1] + 1;
            }
        }
        for(int l = n-2 ; l >= 0 ; l--){
            if(ratings[l] > ratings[l+1]){
                candies[l] = Math.max(candies[l], candies[l+1] + 1);
            }
        }
        int total_candies = 0;
        for(int k = 0 ; k < n ; k++){
            total_candies += candies[k];
        }
        return total_candies;
    }
}