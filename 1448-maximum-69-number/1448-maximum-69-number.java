class Solution {
    public int maximum69Number(int num) {
        String str = String.valueOf(num);
        char[] arr = str.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] - '0' == 6) {
                arr[i] = '9';
                break;
            }
        }
        String s = new String(arr);
        int output = Integer.parseInt(s);
        return output;

        // for(int j = i + 1 ; j < n ; j++){
        //     if(arr[j] - '0' == 9){
        //         arr[j] = '6';
        //         break;
        //     }
        // }
    }
}