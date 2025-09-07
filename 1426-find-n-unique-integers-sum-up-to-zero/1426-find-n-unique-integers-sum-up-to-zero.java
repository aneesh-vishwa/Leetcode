class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        if(n == 1){
            return new int[] {0};
        }
        int k = 1;
        boolean flag = false;

        for(int i = 0 ; i < n ; i += 2){
            if(n - i < 2){
                flag = true;
                break;
            }
            ans[i] = k;
            ans[i+1] = -k;
            k++;
        }
        if(flag){
            ans[n - 1] = 0;
        }
        return ans;
    }
}