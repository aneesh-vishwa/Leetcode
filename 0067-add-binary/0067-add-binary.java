class Solution {
    public String addBinary(String a, String b) {
        int len_a = a.length();
        int len_b = b.length();

        int i = len_a - 1;
        int j = len_b - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i >= 0 || j >= 0 || carry != 0){
            int i_a = 0;
            int i_b = 0;

            if(i >= 0){
                i_a = a.charAt(i) - '0';
            }
            if(j >= 0){
                i_b = b.charAt(j) - '0';
            }
            
            int sum = i_a + i_b + carry;
            sb.append(sum % 2);
            carry = sum / 2; 
            
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}