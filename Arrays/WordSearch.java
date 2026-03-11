/*Problem:  Word Search
Platform: LeetCode  79
Difficulty: Medium
Date: 11 March 2026
Topic: Arrays / Matrix / DFS /Backtracking
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]== word.charAt(0)){
                   if(dfs(board,word,i,j,0)){
                    return true;
                   }
                }
            }
        }
        return false;
    }

    public static boolean dfs(char board[][],String word,int i,int j,int index){
        if(index == word.length()){
            return true;
        }

        if(i<0 || j<0 || i>= board.length||j>= board[0].length){
            return false;
        }

        if(board[i][j] != word.charAt(index)){
            return false;
        }

        char temp = board[i][j];
        board[i][j]='#';

        boolean found = 
        dfs(board,word,i-1,j,index+1) || //up
        dfs(board ,word,i+1,j,index+1)|| //down
        dfs(board,word,i,j+1,index+1)|| //right
        dfs(board,word,i,j-1,index+1);//left

        board[i][j]=temp;

        return found;
    }
}