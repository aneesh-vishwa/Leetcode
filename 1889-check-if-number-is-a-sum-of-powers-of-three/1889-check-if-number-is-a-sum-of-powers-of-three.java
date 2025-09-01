class Solution {
    public boolean checkPowersOfThree(int n) {
        // 1 can be represented as pow(3,0)
        // 3 can be represented as pow(3,1)
        // but 2 can't be represented im power of 3

        while(n>0){
            if(n % 3 == 2){
                return false;
            }
            n = n/3;
        }
        return true;
    }
}