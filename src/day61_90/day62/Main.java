package day61_90.day62;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // 遍历每一个格子作为起点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 深度优先搜索
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // 所有字符匹配完毕
        if (index == word.length()) {
            return true;
        }

        // 越界或字符不匹配
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }

        // 标记当前格子已访问
        char temp = board[i][j];
        board[i][j] = '#';

        // 向四个方向搜索下一个字符
        boolean found = dfs(board, word, i + 1, j, index + 1)
                || dfs(board, word, i - 1, j, index + 1)
                || dfs(board, word, i, j + 1, index + 1)
                || dfs(board, word, i, j - 1, index + 1);

        // 回溯，恢复格子原值
        board[i][j] = temp;

        return found;
    }
}