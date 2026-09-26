class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];

        for(int i=0;i<board.length;i++){
            Arrays.fill(board[i],'.');
        }

        solve(board,0,n);

        return result;
    }

    public void solve(char board[][],int row,int n){
        if(row == n){
            addBoard(board);
            return;
        }

        for(int col=0;col<n;col++){
            if(isSafe(board,row,col,n)){
                board[row][col] = 'Q';
                solve(board,row+1,n);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char board[][],int row,int col,int n){
        for(int i=0;i<row;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //upleft diagonal
        for(int i = row-1, j =col-1 ; i>=0 & j>=0 ;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //upright diagonal
        for(int i = row-1, j =col+1 ; i>=0 & j<n ;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public void addBoard(char board[][]){
        List<String> current = new ArrayList<>();

        for(int i=0;i<board.length;i++){
            current.add(new String(board[i]));
        }

        result.add(current);
    }
}