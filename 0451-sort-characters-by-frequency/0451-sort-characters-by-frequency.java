class Pair{
    char c;
    int freq;
    Pair(int freq , char c){
        this.freq = freq;
        this.c = c;
    }
}
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < arr.length ; i++){
            char ch = arr[i];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        
        for(char key : map.keySet()){
            pq.add(new Pair(map.get(key) , key));
        }
        StringBuilder sb =new StringBuilder();

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int freq = pair.freq;
            char ch = pair.c;

            for(int i = 0 ; i < freq ; i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}