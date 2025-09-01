class Solution {
    public long subArrayRanges(int[] nums) {

         int n = nums.length;
        int[] nge = new int[n];
        int[] pge = new int[n];
        int[] nse = new int[n];
        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();

        // NGE - next greater element (>=)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nge[i] = n;
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        // PGE - previous greater element (strictly >)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                pge[i] = -1;
            } else {
                pge[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        // NSE - next smaller element (<=)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] <= nums[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        // PSE - previous smaller element (strictly <)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[i] < nums[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }
            st.push(i);
        }

        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            long left;
            if (pge[i] == -1) {
                left = i + 1;
            } else {
                left = i - pge[i];
            }

            long right;
            if (nge[i] == n) {
                right = n - i;
            } else {
                right = nge[i] - i;
            }

            maxSum += left * right * 1L * nums[i];
        }

        long minSum = 0;
        for (int i = 0; i < n; i++) {
            long left;
            if (pse[i] == -1) {
                left = i + 1;
            } else {
                left = i - pse[i];
            }

            long right;
            if (nse[i] == n) {
                right = n - i;
            } else {
                right = nse[i] - i;
            }

            minSum += left * right * 1L * nums[i];
        }

        return maxSum - minSum;



        
        // // this problem is a combination of sum of subarray maximum and sum of sun array minimum
        // // sum of sub array maximums

        // int n = nums.length;
        // // NGE of array indices
        // int[] nge = new int[n];
        // Stack<Integer> st_nge = new Stack<>();
        // for (int i = n - 1; i >= 0; i--) {
        //     while (!st_nge.isEmpty() && nums[i] >= nums[st_nge.peek()]) {
        //         st_nge.pop();
        //     }
        //     if (st_nge.isEmpty()) {
        //         nge[i] = n;
        //     } else {
        //         nge[i] = st_nge.peek();
        //     }
        //     st_nge.push(i);
        // }

        // Stack<Integer> st_pge = new Stack<>();
        // int[] pge = new int[n];
        // for (int i = 0; i < n; i++) {
        //     while (!st_pge.isEmpty() && nums[i] >= nums[st_pge.peek()]) {
        //         st_pge.pop();
        //     }
        //     if (st_pge.isEmpty()) {
        //         pge[i] = -1;
        //     } else {
        //         pge[i] = st_pge.peek();
        //     }
        //     st_pge.push(i);
        // }

        // // sum of subarray largst

        // long largest = 0;
        // for (int i = 0; i < n; i++) {
        //     int left = i - pge[i];
        //     int right = nge[i] - i;

        //     if (pge[i] == -1) {
        //         left = i + 1;
        //     }
        //     if (nge[i] == n) {
        //         right = n - i;
        //     }
        //     largest += (long)left * right * nums[i];
        // }

        // // sum of sun array minis

        // //nse

        // Stack<Integer> st_nse = new Stack<>();
        // int[] nse = new int[n];

        // for(int i = n -1 ; i >= 0 ; i--){
        //     while(!st_nse.isEmpty() && nums[i] <= nums[st_nse.peek()]){
        //         st_nse.pop();
        //     }
        //     if(st_nse.isEmpty()){
        //         nse[i] = n;
        //     }
        //     else{
        //         nse[i] = st_nse.peek();
        //     }
        //     st_nse.push(i);
        // }

        // //pse

        // Stack<Integer> st_pse = new Stack<>();
        // int[] pse = new int[n];

        // for(int i = 0 ; i < n ; i++){
        //     while(!st_pse.isEmpty() && nums[i] <= nums[st_pse.peek()]){
        //         st_pse.pop();
        //     }
        //     if(st_pse.isEmpty()){
        //         pse[i] = -1;
        //     }
        //     else{
        //         pse[i] = st_pse.peek();
        //     }
        //     st_pse.push(i);
        // }

        // // cal sum of mins

        // long smaller = 0;

        // for(int i = 0 ; i < n ; i++){
        //     int left_s = i - pse[i];
        //     int right_s = nse[i] - i;
            
        //     if(pse[i] == -1){
        //         left_s = i + 1;
        //     }
        //     if(nse[i] == n){
        //         right_s = n - i;
        //     }
        //     smaller += (long)left_s*right_s*nums[i];
        // }

        // long result = largest - smaller;
        // return result;
    }
}



