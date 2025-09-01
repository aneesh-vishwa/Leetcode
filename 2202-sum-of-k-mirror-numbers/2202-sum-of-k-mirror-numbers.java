// class Solution {
//     public long kMirror(int k, int n) {
//         //k is the base
//         int base = k;
//         int count = 0;
//         int number = 1;
//         long sum = 0;

//         while (count < n) {
//             String str = String.valueOf(number);
//             String rev = new StringBuilder(str).reverse().toString();
//             if (!str.equals(rev)) {
//                 number++;
//                 continue;
//             }
//             int temp = number;
//             StringBuilder sb = new StringBuilder();
//             while (temp > 0) {
//                 int remainder = temp % base;
//                 sb.append(remainder);
//                 temp = temp / base;
//             }

//             String baseKStr = sb.toString();
//             String reversedBaseK = new StringBuilder(baseKStr).reverse().toString();

//             if (baseKStr.equals(reversedBaseK)) {
//                 sum += number;
//                 count++;
//             }

//             number++;
//         }
//         return sum;
//     }
// }



class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;  // Final sum of k-mirror numbers
        int count = 0; // How many valid numbers we've found
        int length = 1; // Length of palindrome we're generating

        // Repeat until we find 'n' such numbers
        while (count < n) {
            // Generate all palindromes of current 'length'
            int start = (int) Math.pow(10, (length - 1) / 2);
            int end = (int) Math.pow(10, (length + 1) / 2);

            for (int half = start; half < end && count < n; half++) {
                long pal = createPalindrome(half, length % 2 == 1);

                // Convert the palindrome to base k
                String baseK = toBaseK(pal, k);

                // Check if base k representation is also a palindrome
                if (isPalindrome(baseK)) {
                    sum += pal;
                    count++;
                }
            }
            length++; // Try longer palindromes
        }

        return sum;
    }

    // Create full palindrome from half
    private long createPalindrome(int half, boolean oddLength) {
        String halfStr = String.valueOf(half);
        StringBuilder sb = new StringBuilder(halfStr);

        // Don't duplicate the middle digit if odd length
        for (int i = halfStr.length() - (oddLength ? 2 : 1); i >= 0; i--) {
            sb.append(halfStr.charAt(i));
        }

        return Long.parseLong(sb.toString());
    }

    // Convert number to base k as a string
    private String toBaseK(long number, int k) {
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            sb.append(number % k);
            number /= k;
        }
        return sb.reverse().toString(); // Because we build the number in reverse
    }

    // Check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
