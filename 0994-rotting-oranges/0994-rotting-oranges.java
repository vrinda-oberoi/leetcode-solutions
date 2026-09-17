class Solution {
    public class Pair{
        int row;
        int col;
        int time;

        Pair(int row,int col,int time){
            this.row = row;
            this.col = col;
            this.time =time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
       
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    //ie rotten hai agr toh sko store krlo phele
                    q.add(new Pair(i,j,0));
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int time = 0;
        int dr[] = {-1,0,0,1};
        int dc[] = {0,1,-1,0};

        while(!q.isEmpty()){
            Pair curr = q.remove();

            int r = curr.row;
            int c = curr.col;
            int t = curr.time;

            time = Math.max(time,t);

            //check all four directions
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >=0 && nr <m && nc>=0 && nc<n && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    fresh--;
                    q.add(new Pair(nr,nc,t+1));
                }
            } 
        }
        if(fresh > 0){
            return -1;
        }

        return time;
    }
}