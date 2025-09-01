class Solution {
    public int largestRectangleArea(int[] heights) {
        // for each and every bar it can expand till the next smaller element and pse 

        // for eg sor the second 2 it can go till end (3) and till (5) just befor the pse

        // nse

        int n = heights.length;
        Stack<Integer> st_nse = new Stack<>();
        int[] nse = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st_nse.isEmpty() && heights[st_nse.peek()] >= heights[i]) {
                st_nse.pop();
            }
            if (st_nse.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = st_nse.peek();
            }
            st_nse.push(i);
        }

        // pse

        Stack<Integer> st_pse = new Stack<>();
        int[] pse = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st_pse.isEmpty() && heights[st_pse.peek()] >= heights[i]) {
                st_pse.pop();
            }
            if (st_pse.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st_pse.peek();
            }
            st_pse.push(i);
        }

        int area = 0;

        for (int i = 0; i < n; i++) {
            if (pse[i] == -1 && nse[i] == n) {
                area = Math.max(area, heights[i] * n);
            } else {
                area = Math.max(area, (nse[i] - pse[i] - 1) * heights[i]);
            }
        }
        return area;
    }
}

// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int n = heights.length;

//         // Next Smaller Element (NSE)
//         Stack<Integer> st_nse = new Stack<>();
//         int[] nse = new int[n];

//         for (int i = n - 1; i >= 0; i--) {
//             while (!st_nse.isEmpty() && heights[st_nse.peek()] >= heights[i]) {
//                 st_nse.pop();
//             }

//             if (st_nse.isEmpty()) {
//                 nse[i] = n;
//             } else {
//                 nse[i] = st_nse.peek();
//             }

//             st_nse.push(i);
//         }

//         // Previous Smaller Element (PSE)
//         Stack<Integer> st_pse = new Stack<>();
//         int[] pse = new int[n];

//         for (int i = 0; i < n; i++) {
//             while (!st_pse.isEmpty() && heights[st_pse.peek()] >= heights[i]) {
//                 st_pse.pop();
//             }

//             if (st_pse.isEmpty()) {
//                 pse[i] = -1;
//             } else {
//                 pse[i] = st_pse.peek();
//             }

//             st_pse.push(i);
//         }

//         // Area calculation
//         int area = 0;

//         for (int i = 0; i < n; i++) {
//             if (pse[i] == -1 && nse[i] == n) {
//                 area = Math.max(area, heights[i] * n);
//             } else {
//                 area = Math.max(area, (nse[i] - pse[i] - 1) * heights[i]);
//             }
//         }

//         return area;
//     }
// }
