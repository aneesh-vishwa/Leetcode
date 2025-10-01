class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = 0;
        int empty_bottles = numBottles;
        while(empty_bottles >= numExchange){
            
            count += empty_bottles/numExchange;
            empty_bottles = empty_bottles/numExchange + empty_bottles % numExchange;

        }
        return count + numBottles;
    }
}