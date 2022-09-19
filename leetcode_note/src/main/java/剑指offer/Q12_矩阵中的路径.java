package 剑指offer;

/**
 * @date 2022/1/5 15:45
 */
public class Q12_矩阵中的路径 {


    class Solution {
        public boolean exist(char[][] board, String word) {
            /*
                这题我的思路立马想到了，dfs，对矩阵中每个点出发，然后dfs判断
                时间复杂度应该是o（3‘k MN）

             */
            char[] words = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, words, i, j, 0)) return true;
                }
            }
            return false;
        }

        boolean dfs(char[][] board, char[] word, int i, int j, int k) {
            if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
            if (k == word.length - 1) return true;
            board[i][j] = '\0';
            boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                    dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
            board[i][j] = word[k];
            return res;
        }

    }
}
