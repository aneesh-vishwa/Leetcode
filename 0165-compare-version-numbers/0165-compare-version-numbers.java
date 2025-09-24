class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr_1 = version1.split("\\.");
        String[] arr_2 = version2.split("\\.");
        int m = arr_1.length;
        int n = arr_2.length;
        int i = 0;
        int j = 0;

        while(i < m && j < n){
            int num_1 = Integer.parseInt(arr_1[i]);
            int num_2 = Integer.parseInt(arr_2[j]);
            if(num_1 < num_2){
                return -1;
            }
            else if(num_1 > num_2){
                return 1;
            }
            i++;
            j++;
        }
        while(j < n){
            int num_1 = 0;
            int num_2 = Integer.parseInt(arr_2[j]);
            if(num_1 < num_2){
                return -1;
            }
            else if(num_1 > num_2){
                return 1;
            }
            j++;
        }
        while(i < m){
            int num_1 = Integer.parseInt(arr_1[i]);
            int num_2 = 0;
            if(num_1 < num_2){
                return -1;
            }
            else if(num_1 > num_2){
                return 1;
            }
            i++;
        }
        return 0;
    }
}