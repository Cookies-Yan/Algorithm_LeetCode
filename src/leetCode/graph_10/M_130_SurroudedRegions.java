package leetCode.graph_10;

public class M_130_SurroudedRegions {

    /**
     * dfs 解法
     * Time O(m * n)
     * Space O(n) 栈空间
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length - 1;
        int n = board[0].length - 1;

        //行
        for (int i = 0; i <= m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n] == 'O') {
                dfs(board, i, n);
            }
        }

        //列
        for (int i = 0; i <= n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m][i] == 'O') {
                dfs(board, m, i);
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        //这里没有 i, j <= 0 是因为之前已经判断过 i, j = 0 是不是为'O'的情况了
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '1';
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
    }
}
