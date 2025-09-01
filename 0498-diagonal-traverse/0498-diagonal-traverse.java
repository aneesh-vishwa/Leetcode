class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] output = new int[m*n];
        boolean direction = false;
        int k = 0;

        for(int i = 0 ; i < n ; i++){
            ArrayList<Integer> list = new ArrayList<>();
            int a = 0;
            int b = i;
            while(a >= 0 && a < m && b >= 0 && b < n){
                list.add(mat[a][b]);
                a++;
                b--;
            }
            if(!direction){
                int size = list.size();
                int l = size - 1;
                while(l >= 0){
                    output[k] = list.get(l);
                    k++;
                    l--;
                }
                direction = !direction;
            }
            else{
                int size = list.size();
                int l = 0;
                while(l < size){
                    output[k] = list.get(l);
                    k++;
                    l++;
                }
                direction = !direction;
            }
        }

        for(int i = 1 ; i < m ; i++){
            ArrayList<Integer> list = new ArrayList<>();
            int a = i;
            int b = n - 1;
            while(a >= 0 && a < m && b >= 0 && b < n){
                list.add(mat[a][b]);
                a++;
                b--;
            }
            if(!direction){
                int size = list.size();
                int l = size - 1;
                while(l >= 0){
                    output[k] = list.get(l);
                    k++;
                    l--;
                }
                direction = !direction;
            }
            else{
                int size = list.size();
                int l = 0;
                while(l < size){
                    output[k] = list.get(l);
                    k++;
                    l++;
                }
                direction = !direction;
            }
        }
        return output;
    }
}