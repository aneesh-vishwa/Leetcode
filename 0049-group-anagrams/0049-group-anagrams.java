class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        HashMap<String , List<String>> map = new HashMap<>();

        //for every string in the arr we need to create a new array of size 26

        for(String s : strs){
            int[] alphabet = new int[26];
            
            // we need to count the freq of each letter in the string s

            for(char ch : s.toCharArray()){
                alphabet[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int num : alphabet){
                sb.append(num).append("/");
            }
            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key , new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

/* 

List<List<String>> output = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        
        for (String s : strs) {
            set.add(s);
        }

        for (int i = 0; i < strs.length; i++) {
            String current = strs[i];
            if (!set.contains(current)) continue;

            List<String> list = new ArrayList<>();
            list.add(current);
            set.remove(current);

            char[] currentChars = current.toCharArray();
            Arrays.sort(currentChars);
            String sortedCurrent = new String(currentChars);

            for (int j = i + 1; j < strs.length; j++) {
                String candidate = strs[j];
                if (!set.contains(candidate)) continue;

                char[] candChars = candidate.toCharArray();
                Arrays.sort(candChars);
                String sortedCand = new String(candChars);

                if (sortedCand.equals(sortedCurrent)) {
                    list.add(candidate);
                    set.remove(candidate);
                }
            }

            output.add(list);
        }

        return output;

*/
