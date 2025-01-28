public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // Loop through every cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start DFS if the first character matches
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        
        // If no valid path is found
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // If the index reaches the length of the word, we have successfully found the word
        if (index == word.length()) {
            return true;
        }

        // Check if current position is out of bounds or does not match the current character
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Save the current character and mark the cell as visited by replacing it with a temporary character
        char temp = board[i][j];
        board[i][j] = '#';  // Mark the cell as visited to avoid revisiting

        // Explore the four adjacent directions (up, down, left, right)
        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);

        // Backtrack: Restore the cell's original character
        board[i][j] = temp;

        return found;
    }
}
