package day25;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 3;
        System.out.println(solution.searchMatrix(matrix, target));
    }
}

@SuppressWarnings("all")
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 边界检查
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 从右上角开始
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            int current = matrix[row][col];
            if (current == target) {
                return true;
            } else if (current > target) {
                // 当前值大于目标，向左移动（排除当前列）
                col--;
            } else {
                // 当前值小于目标，向下移动（排除当前行）
                row++;
            }
        }

        return false;
    }
}