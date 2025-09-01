class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        int count = 0;

        for(int fruit : fruits){
            boolean found = false;
            for(int i = 0 ; i < n ; i++){
                if(fruit <= baskets[i]){
                    baskets[i] = 0;
                    found = true;
                    break;
                }
            }
            if(!found){
                count++;
            }
        }
        return count;


        // LinkedHashSet<Integer> set = new LinkedHashSet<>();

        // for(int it : baskets){
        //     set.add(it);      //this does follow the order but will skip the duplicates
        // }

        // LinkedList<Integer> basketList = new LinkedList<>();

        // for (int basket : baskets) {
        //     basketList.add(basket); // preserves duplicates and insertion order
        // }
        // int count = 0;
        // int i = 0;
        // while(i < fruits.length){
        //     int fruit = fruits[i];
        //     Iterator<Integer> itr = basketList.iterator();
        //     boolean found = false;
        //     while (itr.hasNext()) {
        //         int num = itr.next();
        //         if (num >= fruit) {
        //             itr.remove();
        //             found = true;
        //             break;
        //         }
        //     }
        //     if(!found){
        //         count++;
        //     }
        //     i++;
        // }
        // return count;
    }
}