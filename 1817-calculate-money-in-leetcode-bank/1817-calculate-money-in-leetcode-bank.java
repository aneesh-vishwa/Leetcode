class Solution {
    public int totalMoney(int n) {
        if(n <= 7){
            return n*(n+1)/2;
        }
        int sets = n/7;
        int rem_days = n % 7;
        int present = 28;
        int monday = 1;
        int sum = 0;
        for(int i = 0 ; i < sets ; i++){
            sum += present;
            present += 7;
            monday++;
        }
        if(rem_days > 0){
            for(int i = 0 ; i < rem_days ; i++){
                sum += monday;
                monday++;
            }
        }
        return sum;
    }
}