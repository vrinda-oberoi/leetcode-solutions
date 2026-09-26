class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean visited[][] = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    if(search(board,word,i,j,0,visited)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean search(char board[][],String word,int row,int col,int index,boolean visited[][]){

        if(index == word.length()-1){
            return true;
        }

        visited[row][col] = true;

        int dr[] ={-1,1,0,0};
        int dc[] = {0,0,-1,1};

        for(int i=0;i<4;i++){
            int newRow = row + dr[i];
            int newCol = col+ dc[i];

            if(newRow >= 0 && newRow < board.length && newCol >=0 && newCol < board[0].length && !visited[newRow][newCol] && board[newRow][newCol] == word.charAt(index+1)){
                if(search(board,word,newRow,newCol,index+1,visited)){
                    return true;
                }
            }
        }

        visited[row][col] = false;
        return false;
    }
}