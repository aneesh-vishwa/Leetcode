class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Tuple {
    int stops;
    int node;
    int price;

    Tuple(int stops, int node, int price) {
        this.stops = stops;
        this.node = node;
        this.price = price;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int m = flights.length;
        // int n = filghts[0].length;
        int[] price_arr = new int[n];
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            price_arr[i] = Integer.MAX_VALUE;
        }
        price_arr[src] = 0;
        for (int i = 0; i < m; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int d = flights[i][2];
            adj.get(u).add(new Pair(v, d));
        }
        // you can use queue or pq as as we compare ther no of stops and that stops
        // increasing only by 1

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0));
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            int stops = tuple.stops;
            int node = tuple.node;
            int price = tuple.price;

            for (Pair it : adj.get(node)) {
                int it_node = it.node;
                int distance = it.distance;
                if (stops > k) {
                    continue;
                }
                if (price_arr[it_node] >= price + distance) {
                    price_arr[it_node] = price + distance;
                    queue.add(new Tuple(stops + 1, it_node, price_arr[it_node]));
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(price_arr[i] == Integer.MAX_VALUE){
                price_arr[i] = -1;
            }
        }
        // if(price_arr[dst] == Integer.MAX_VALUE){
        //     price_arr[dst] = -1;
        // }
        return price_arr[dst];
    }
}