class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = (int)1e9;
        int dist[] = new int[n];

        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;

        for(int i =0;i<=k;i++){
            int temp[] = dist.clone();

            for(int flight[] : flights){
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if (dist[from] != INF) {
                    temp[to] = Math.min(
                        temp[to],
                        dist[from] + price
                    );
                }
            }
           dist = temp;
        }

        if(dist[dst] == 1e9){
            return -1;
        }

        return dist[dst];
         
    }
}