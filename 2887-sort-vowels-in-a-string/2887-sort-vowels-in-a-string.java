class Pair{
    int value;
    char character;
    Pair(int value , char character){
        this.value = value;
        this.character = character;
    }
}
class Solution {
    public String sortVowels(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> a.value - b.value);
        int n = s.length();
        char[] arr = s.toCharArray();

        for(int i = 0 ; i < n ; i++){
            if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u' || arr[i] == 'A' || arr[i] == 'E' || arr[i] == 'I' || arr[i] == 'O' || arr[i] == 'U'){
                pq.add(new Pair(arr[i] - 'A' , arr[i]));
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ; i++){
            if(arr[i] != 'a' && arr[i] != 'e' && arr[i] != 'i' && arr[i] != 'o' && arr[i] != 'u' && arr[i] != 'A' && arr[i] != 'E' && arr[i] != 'I' && arr[i] != 'O' && arr[i] != 'U'){
                sb.append(arr[i]);
                continue;
            }
            if(!pq.isEmpty()){
                Pair pair = pq.poll();
                char ch = pair.character;
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}