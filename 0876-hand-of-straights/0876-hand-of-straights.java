class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0){
            return false;
        }
        Arrays.sort(hand);
        TreeMap<Integer , Integer> map = new TreeMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(hand[i] , map.getOrDefault(hand[i] , 0) + 1);
        }
        for(int card : hand){
            if(map.get(card) == 0){
                continue;
            }
            for(int i = 0 ; i < groupSize ; i++){
                if(map.get(card + i) == null || map.get(card + i) == 0){
                    return false;
                }
                else{
                    map.put(card + i , map.get(card + i) - 1);
                }
            }
        }

        return true;
    }
}