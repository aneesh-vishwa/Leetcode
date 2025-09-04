class Solution {
    public int findClosest(int x, int y, int z) {
        while(x != z || y != z){
            if(x == z && y == z) return 0;
            if(x == z && y != z) return 1;
            if(y == z && x != z) return 2;

            if(x < z){
                x++;
            }
            else{
                x--;
            }

            if(y < z){
                y++;
            }
            else{
                y--;
            }
        }
        return 0;
    }
}