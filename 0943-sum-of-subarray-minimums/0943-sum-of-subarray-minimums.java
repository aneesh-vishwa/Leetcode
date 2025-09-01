class Solution {
    public int sumSubarrayMins(int[] arr) {
        // nse
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st1 = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st1.isEmpty() && arr[i] < arr[st1.peek()]) {
                st1.pop();
            }
            if (st1.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = st1.peek();
            }
            st1.push(i);
        }


        //pse

        int[] pse = new int[n];
        Stack<Integer> st2 = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(!st2.isEmpty() && arr[i] <= arr[st2.peek()]){
                st2.pop();
            }
            if(st2.isEmpty()){
                pse[i] = -1;
            }
            else{
                pse[i] = st2.peek();
            }
            st2.push(i);
        }



        //sum calulation using nse and pse

        long sum = 0;
        for(int i = 0 ; i < n ; i++){
            //cal no no sub array where arr[i] is minimum 
            int left = i - pse[i];
            int right = nse[i] - i;

            if(pse[i] == -1){
                left = i+1;
            }
            if(nse[i] == n){
                right = n-i;
            }

            sum = (sum + (long)left * right * arr[i]) % 1000000007;

        }
        return (int)sum;
    }
}