class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> output = new ArrayList<>();
        for(int i = 0 ; i < words.length ; i++){
            for(int j = 0 ; j < words[i].length() ; j++){
                if(words[i].charAt(j) == x){
                    output.add(i);
                    break;
                }
            }

            // if(words[i].indexOf(x) != -1){
            //     output.add(i);
            // }
        }
        return output;
    }
}