class Solution {
    public int differenceOfSums(int n, int m) {
        int total = (n*(n+1))/2;
        int non_div = 0;
        for(int i=1;i<=n;i++){
            if(i%m != 0)
                non_div += i;
        }
        return 2*non_div - total;
    }
}