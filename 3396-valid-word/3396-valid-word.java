class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        
        boolean vowel = false;
        boolean consonant = false;

        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!Character.isLetterOrDigit(arr[i])) {
                return false;
            }
            if (Character.isLetter(arr[i])) {
                char ch = Character.toLowerCase(arr[i]);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowel = true;
                } else {
                    consonant = true;
                }
            } 

        }
        if (vowel && consonant) {
            return true;
        }
        return false;
    }
}