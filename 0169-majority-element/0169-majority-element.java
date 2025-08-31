class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<n;i++){
        //     map.put(i, map.getOrDefault(i, 0) + 1);
        // }
        // int maxCount = 0;
        // int mostFrequentElement = -1;

        // for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if (entry.getValue() > maxCount) {
        //         maxCount = entry.getValue();
        //         mostFrequentElement = entry.getKey();
        //     }
        // }
        // return mostFrequentElement;


        int count = 0;
        int target = nums[0];
        for(int i=0;i<n;i++){
            
            if(target == nums[i]){
                count++;
            }
            else if(target != nums[i] && count > 0){
                count--;
            }
            else if(count == 0){
                target =nums[i];
                count = 1;
            }
            

        }
        return target;
       
    }
    
    
}