class Solution {
    public String largestGoodInteger(String num) {
        char[] arr = num.toCharArray();
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i < n - 1 ; i++){
            if(arr[i - 1] == arr[i] && arr[i] == arr[i + 1]){
                max = Math.max(max , arr[i] - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        if(max >= 0){
            sb.append(max).append(max).append(max);
        }
        else{
            sb.append("");
        }
        
        return sb.toString();
    }
}