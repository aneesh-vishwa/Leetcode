class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k){
            return "0";
        }
        StringBuilder number = new StringBuilder(num);
        char[] arr = number.toString().toCharArray();
        Stack<Character> st = new Stack<>();
        // we need to build a monostatic inc stack of numbers in the string
        for(int i = 0 ; i < arr.length ; i++){
            while(!st.isEmpty() && arr[i] < st.peek() && k > 0){
                st.pop();
                k--;
            }
            st.push(arr[i]);
        }
        while(k>0){
            st.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        for(char ch : st){
            result.append(ch);
        }
        while(result.length() > 1 && result.charAt(0) == '0'){
            result.deleteCharAt(0);
        }

        String output = result.toString();
        return output;




















        // StringBuilder number = new StringBuilder(num);
        // char[] arr = number.toString().toCharArray();
        // int n = arr.length;
        // Stack<Character> st = new Stack<>();
        // st.push(arr[0]);
        // for (int i = 1; i < n; i++) {
        //     while (k > 0 && !st.isEmpty() && arr[i] < st.peek()) {
        //         st.pop();
        //         k--;
        //     }
        //     if (st.isEmpty() || arr[i] > st.peek() || k <= 0) {
        //         st.push(arr[i]);
        //     }

        // }

        // while (k > 0 && !st.isEmpty()) {
        //     st.pop();
        //     k--;
        // }

        // int m = st.size();
        // String[] ans = new String[m];

        // for(int i = 0 ; i < m ; i++){
        //     ans[i] = st.pop();
        // }
        // return ans;

        // StringBuilder ans = new StringBuilder();
        // while (!st.isEmpty()) {
        //     ans.insert(0, st.pop()); // Insert at the beginning
        // }

        // // Remove leading zeros
        // while (ans.length() > 1 && ans.charAt(0) == '0') {
        //     ans.deleteCharAt(0);
        // }

        // return ans.length() == 0 ? "0" : ans.toString();

    }
}