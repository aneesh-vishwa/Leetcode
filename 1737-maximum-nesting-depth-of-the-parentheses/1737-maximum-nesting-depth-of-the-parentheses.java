class Solution {
    public int maxDepth(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        int max_count = 0;

        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == '('){
                count++;
                
            }
            else if(arr[i] == ')'){
                count--;
            }
            
            else{
                continue;
            }
            max_count = Math.max(max_count , count);
        }
        return max_count;
    }
}