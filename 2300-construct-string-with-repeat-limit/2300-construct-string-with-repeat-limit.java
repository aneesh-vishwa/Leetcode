class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < arr.length ; i++){
            freq[arr[i] - 'a']++;
        }
        int i = 25;

        while(i >= 0){
            char ch = (char)('a' + i);

            if(freq[i] == 0){
                i--;
                continue;
            }

            int no_of_times = repeatLimit;
            while(no_of_times > 0 && freq[i] > 0){
                sb.append(ch);
                freq[i]--;
                no_of_times--;
            }
            if(freq[i] > 0){
                int j = i - 1;
                while(j >= 0){
                    if(freq[j] > 0){
                        break;
                    }
                    j--;
                }
                if (j < 0) break;
                char smaller = (char)(j + 'a');
                sb.append(smaller);
                freq[j]--;
            }
            else{
                i--;
            }
        }
        return sb.toString();
    }
}