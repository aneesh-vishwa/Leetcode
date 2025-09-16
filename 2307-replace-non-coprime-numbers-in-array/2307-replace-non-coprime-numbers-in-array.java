class Solution {
    /* 
         a*b = lcm(a,b)*gcd(a,b) 
    */

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();

        for (int num : nums) {
            st.push(num);

            while (st.size() > 1) {
                int first = st.pop();
                int second = st.pop();

                if (gcd(first, second) > 1) {
                    st.push(lcm(first, second));
                } else {
                    st.push(second);
                    st.push(first);
                    break;
                }
            }
        }

        return new ArrayList<>(st);
    }
}
