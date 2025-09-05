class Pair{
    int num;
    int group_size;
    Pair(int num , int group_size){
        this.num = num;
        this.group_size = group_size;
    }
}
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        // HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> a.group_size - b.group_size);
        int n = groupSizes.length;

        for(int i = 0 ; i < n ; i++){
            pq.add(new Pair(i , groupSizes[i]));
        }

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int size = pair.group_size;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(pair.num);
            for(int i = 0 ; i < size - 1 ; i++){
                Pair temp = pq.poll();
                if(temp.group_size == size){
                    list.add(temp.num);
                }
                else{
                    break;
                }
            }
            ans.add(list);
        }
        return ans;
    }
}