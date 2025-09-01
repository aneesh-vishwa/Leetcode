class Solution {
    public boolean lemonadeChange(int[] bills) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int n = bills.length;
        // for (int i = 0; i < n; i++) {
        //     if (bills[i] == 5) {
        //         map.put(5, map.getOrDefault(5, 0) + 1);
        //     } else if (bills[i] == 10 && map.getOrDefault(5, 0) >= 1) {
        //         map.put(10, map.getOrDefault(10, 0) + 1);
        //         map.put(5, map.get(5) - 1);
        //     } else if (bills[i] == 20 && map.getOrDefault(10, 0) >= 1 && map.getOrDefault(5, 0) >= 1) {
        //         map.put(20, map.getOrDefault(20, 0) + 1);
        //         map.put(10, map.get(10) - 1);
        //         map.put(5, map.get(5) - 1);

        //     } else if (bills[i] == 20 && map.getOrDefault(5, 0) >= 3) {
        //         map.put(20, map.getOrDefault(20, 0) + 1);
        //         map.put(5, map.get(5) - 3);
        //     }

        //     else {
        //         return false;
        //     }
        // }
        // return true;

        int five = 0;
        int ten = 0;
        int n = bills.length;
        for (int i =0;i<n;i++){
            if(bills[i] == 5){
                five++;
            }
            if(bills[i] == 10){
                if(five >= 1){
                    five--;
                    ten++;
                }
                else{return false;}
            }
            if(bills[i] == 20){
                if(ten >=1 && five >= 1){
                    ten--;
                    five--;
                }
                else if(ten < 1 && five >= 3){
                    five -= 3;
                }
                else{return false;}
            }
        }
        return true;

    }
}