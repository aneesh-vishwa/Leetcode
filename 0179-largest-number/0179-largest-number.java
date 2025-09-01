class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));

        for(int num : nums){
            pq.add(String.valueOf(num));
        }
        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()){
            result.append(pq.poll());
        }

        // Edge case: when the result is something like "0000", return "0"
        if (result.charAt(0) == '0') {
            return "0";
        }
        return result.toString();


        // for (int i = 0; i < nums.length; i++) {
        //     // if (nums[i] <= 9) {
        //     //     pq.add(nums[i]);
        //     // } 
        //     // else {
        //     while (nums[i] <= 9) {
        //         pq.add(nums[i] % 10);
        //         nums[i] = nums[i] / 10;
        //     }
        //     pq.add(nums[i]);
        // }
        // // }
        // String res = "";
        // while (!pq.isEmpty()) {
        //     int num = pq.poll();
        //     String s = String.valueOf(num);
        //     res += s;
        // }
        // return res;
    }
}




// class Solution {
//     public String largestNumber(int[] nums) {
//         // PriorityQueue comparing by string concatenation logic
//         PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));

//         // Add all numbers as strings
//         for (int num : nums) {
//             pq.add(String.valueOf(num));
//         }

//         // Build result string
//         StringBuilder res = new StringBuilder();
//         while (!pq.isEmpty()) {
//             res.append(pq.poll());
//         }

//         // Edge case: when the result is something like "0000", return "0"
//         if (res.charAt(0) == '0') {
//             return "0";
//         }

//         return res.toString();
//     }
// }
