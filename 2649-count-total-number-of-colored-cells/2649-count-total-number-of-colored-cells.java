class Solution {
    public long coloredCells(int n) {
        long ans = 1;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return ans;
        }
        for(int i = 1; i< n;i++){
            ans = ans + 4*i;
        }
        return ans;
    }
}