class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        for(int i = 0;i<n;i++){
            if(st.isEmpty() || asteroids[i] > 0){
                st.push(asteroids[i]);
            }
            else {
                while (!st.isEmpty() && st.peek() > 0 && (st.peek() + asteroids[i]) < 0) {
                    st.pop();
                }
                if (st.isEmpty() || st.peek() < 0) {
                    st.push(asteroids[i]);
                } 
                else if (st.peek() + asteroids[i] == 0) {
                    st.pop();
                }
            }
        }
        int m = st.size();
        int[] output = new int[m];

        for(int i = m-1; i>=0;i--){
            output[i] = st.peek();
            st.pop();
        }
        return output;
    }
}