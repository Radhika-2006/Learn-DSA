class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isSafe(board, row, col, ch)) {
                            board[row][col] = ch;

                            if (solve(board)) {
                                return true;
                            }

                            board[row][col] = '.'; // backtrack
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public boolean isSafe(char[][] board, int row, int col, char ch) {

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch) return false; // row check

            if (board[i][col] == ch) return false; // column check

            int r = 3 * (row / 3) + i / 3;
            int c = 3 * (col / 3) + i % 3;

            if (board[r][c] == ch) return false; // 3x3 box check
        }

        return true;
    }
}