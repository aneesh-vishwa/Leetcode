class Solution {
    public String convert(String s, int numRows) {
        int k = 2*numRows - 2;
        int string_length = s.length();

        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder ans = new StringBuilder();
        for(int row = 0 ; row < numRows ; row++){
            int i = row;
            boolean toggle = true;

            int step1 = k - 2*row;
            int step2 = 2*row;

            while(i < string_length){
                ans.append(s.charAt(i));
                if(row == 0 || row == numRows - 1){
                    i += k;
                }
                else{
                    if(toggle){
                        i += step1;
                    }
                    else{
                        i += step2;
                    }
                    toggle = !toggle;
                }
            }
        }
        return ans.toString();
    }
}