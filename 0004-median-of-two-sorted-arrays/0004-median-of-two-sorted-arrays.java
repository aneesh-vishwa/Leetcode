class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int k = n + m;
        int index2 = k / 2;
        int index1 = index2 - 1;
        int element1 = 0;
        int element2 = 0;
        int i = 0, j = 0, counter = 0;

        // Handle cases where one of the arrays is empty
        if (n == 0) { // Added check for when nums1 is empty
            if (m % 2 == 0) {
                return (nums2[m / 2 - 1] + nums2[m / 2]) / 2.0; 
            } else {
                return nums2[m / 2]; 
            }
        }
        if (m == 0) { // Added check for when nums2 is empty
            if (n % 2 == 0) {
                return (nums1[n / 2 - 1] + nums1[n / 2]) / 2.0;
            } else {
                return nums1[n / 2]; 
            }
        }

        // Merge process to find the median
        while (i < n && j < m) {
            int current;
            if (nums1[i] <= nums2[j]) {
                current = nums1[i++];
            } else {
                current = nums2[j++];
            }
            if (counter == index1) element1 = current; // Updated logic to track `element1`
            if (counter == index2) element2 = current; // Updated logic to track `element2`
            counter++;
        }

        // Handle remaining elements in nums1
        while (i < n) { // Moved the loop outside the main merge loop
            if (counter == index1) element1 = nums1[i];
            if (counter == index2) element2 = nums1[i];
            i++;
            counter++;
        }

        // Handle remaining elements in nums2
        while (j < m) { // Moved the loop outside the main merge loop
            if (counter == index1) element1 = nums2[j];
            if (counter == index2) element2 = nums2[j];
            j++;
            counter++;
        }

        // Return the median
        if (k % 2 == 0) {
            return (element1 + element2) / 2.0; // Even length
        } else {
            return element2; // Odd length
        }
    }
}
