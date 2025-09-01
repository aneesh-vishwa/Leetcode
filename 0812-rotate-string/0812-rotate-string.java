class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        for(int i=0;i<n;i++){
            String firstPart = s.substring(0, 1);
            String secondPart = s.substring(1);
            s = secondPart + firstPart;
            if(s.equals(goal)){
                return true;
            }
        }
        return false;
    }
}