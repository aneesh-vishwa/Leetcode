class Solution {
    public int maxArea(int[] height) {
        //prefix and suffix arrays
        int n = height.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = height[0];
        suffix[n - 1] = height[n - 1];

        for(int i = 1 ; i < n ; i++){
            prefix[i] = Math.max(prefix[i - 1] , height[i]);
        }

        for(int i = n - 2  ; i >= 0 ; i--){
            suffix[i] = Math.max(suffix[i + 1] , height[i]);
        }

        int left = 0 ;
        int right = n - 1;
        int max_area = 0;
        int area = 0;

        while(left < right){
            area = Math.min(prefix[left] , suffix[right]) * (right - left);
            max_area = Math.max(area , max_area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max_area;
    }
}