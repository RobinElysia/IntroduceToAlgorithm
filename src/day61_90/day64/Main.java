package day61_90.day64;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        // 用于标记列、主对角线、副对角线是否被占用
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // 主对角线：row + col
        boolean[] diag2 = new boolean[2 * n - 1]; // 副对角线：row - col + n - 1
        char[][] board = new char[n][n];
        // 初始化棋盘全为 '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(res, board, col, diag1, diag2, 0, n);
        return res;
    }

    private void backtrack(List<List<String>> res, char[][] board, boolean[] col,
                           boolean[] diag1, boolean[] diag2, int row, int n) {
        if (row == n) {
            // 找到一个解，将当前棋盘转为 List<String> 并加入结果
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            res.add(solution);
            return;
        }
        for (int c = 0; c < n; c++) {
            int d1 = row + c;
            int d2 = row - c + n - 1;
            if (col[c] || diag1[d1] || diag2[d2]) {
                continue; // 冲突，跳过
            }
            // 放置皇后
            board[row][c] = 'Q';
            col[c] = diag1[d1] = diag2[d2] = true;
            // 处理下一行
            backtrack(res, board, col, diag1, diag2, row + 1, n);
            // 撤销选择（回溯）
            board[row][c] = '.';
            col[c] = diag1[d1] = diag2[d2] = false;
        }
    }
}