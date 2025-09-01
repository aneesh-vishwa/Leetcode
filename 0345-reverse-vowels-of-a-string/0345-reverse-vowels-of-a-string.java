class Solution {
    public String reverseVowels(String s) {
        // int n = s.length();
        // HashSet<Character> set = new HashSet<>();
        // set.add('a');
        // set.add('e');
        // set.add('i');
        // set.add('o');
        // set.add('u');
        // set.add('A');
        // set.add('E');
        // set.add('I');
        // set.add('O');
        // set.add('U');

        // int left = 0;
        // int right = n - 1;
        // char[] arr = s.toCharArray();

        // while(left < right){
        //     if(set.contains(arr[left]) && set.contains(arr[right])){
        //         char temp = arr[left];
        //         arr[left] = arr[right];
        //         arr[right] = temp;
        //         left++;
        //         right--;
        //     }
        //     else if(set.contains(arr[left]) && !set.contains(arr[right])){
        //         right--;
        //     }
        //     else if(!set.contains(arr[left]) && set.contains(arr[right])){
        //         left++;
        //     }
        //     else{
        //         left++;
        //         right--;
        //     }
        // }
        // String str = new String(arr);
        // return str;

         char[] chars = s.toCharArray();
        boolean[] isVowels = new boolean[128];

        for (char c : new char[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' })
            isVowels[c] = true;

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (!isVowels[chars[left]])
                left++;
            else if (!isVowels[chars[right]])
                right--;
            else {
                char temp = chars[right];
                chars[right] = chars[left];
                chars[left] = temp;
                left++;
                right--;
            }
        }

        return new String (chars);
    }
}