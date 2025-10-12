class Pair{
    int x;
    int y;
    float div;
    Pair(int x , int y , float div){
        this.x = x;
        this.y = y;
        this.div = div;
    }
}
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int[] output = new int[2];
        int n = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Float.compare(a.div, b.div));

        for(int i = 0 ; i < n - 1; i++){
            for(int j = i + 1 ; j < n ; j++){
                pq.offer(new Pair(i , j , (float)arr[i]/arr[j]));
            }
        }

        for(int i = 0 ; i < k - 1; i++){
            pq.poll();
        }
        Pair pair = pq.poll();

        output[0] = arr[pair.x];
        output[1] = arr[pair.y];
        
        return output;
    }
}