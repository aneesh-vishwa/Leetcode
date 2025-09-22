public class Solution {
    public int maxFrequencyElements(int[] nums) {
int[] freq=new int[101];
        int maxFreq=0;
        for(int num:nums){
            freq[num]++;
            if(freq[num]>maxFreq){
                maxFreq=freq[num];
            }
        }
        int result=0;
        for(int f:freq){
            if(f==maxFreq){
                result+=f;
            }
        }
        return result;
    }
}