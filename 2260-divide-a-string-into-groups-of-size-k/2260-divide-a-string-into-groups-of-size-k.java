class Solution {
    public String[] divideString(String s, int k, char fill) {
        int string_len = s.length();
        List<String> list = new ArrayList<>();

        while(string_len > 0){
            if(string_len >= k){
                list.add(s.substring(0,k));
                s = s.substring(k);
                string_len -= k;
            }
            else if(string_len < k && string_len > 0){
                StringBuilder sb = new StringBuilder();
                int extra = k - string_len;
                sb.append(s);
                for(int i = 0 ; i < extra ; i++){
                    sb.append(fill);
                }
                list.add(sb.toString());
                break;
            }
        }
        int list_size = list.size();
        String[] output = new String[list_size];
        for(int i = 0 ; i < list_size ; i++){
            output[i] = list.get(i);
        }
        return output;
    }
}