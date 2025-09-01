class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;
        List<Integer> list = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            list.add(sum % 10);
        }
        if (carry > 0) {
            list.add(carry);
        }

        Collections.reverse(list);
        int[] output = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            output[i] = list.get(i);
        }
        return output;
    }
}