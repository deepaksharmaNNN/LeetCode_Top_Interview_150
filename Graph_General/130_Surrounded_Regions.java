class Solution {
    private void dfs(char[][] board, int row, int col, boolean[][] vis){
        int n = board.length;
        int m = board[0].length;
        if(row >= 0 && row < n && col >= 0 && col < m && vis[row][col] == false && board[row][col] == 'O'){
            vis[row][col] = true;
            dfs(board, row + 1, col, vis);
            dfs(board, row - 1, col, vis);
            dfs(board, row, col + 1, vis);
            dfs(board, row, col - 1, vis);
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || i == n - 1 || j == 0  || j == m - 1){
                    if(vis[i][j] == false && board[i][j] == 'O'){
                        dfs(board, i, j, vis);
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && vis[i][j] == false){
                    board[i][j] = 'X';
                }
            }
        }
    }
}