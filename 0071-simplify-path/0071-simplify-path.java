class Solution {
    public String simplifyPath(String path) {
        String[] words = path.split("/");
        Stack<String> st = new Stack<>();

        for(String word : words){
            if(word.equals("") || word.equals(".")){
                continue;
            }
            if(word.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
                // st.pop();
                continue;
            }
            st.push(word);
        }
        
        // st.push("/");
        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.insert(0, "/" + st.pop());
        }
        if(sb.toString().isEmpty()){
            sb.append("/");
        }
        return sb.toString();
       
    }
}