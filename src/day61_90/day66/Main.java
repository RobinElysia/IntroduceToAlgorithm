package day61_90.day66;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { // 边界检查
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 从右上角开始搜索
        int l = 0;
        int r = cols * rows - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midValue = matrix[mid / cols][mid % cols]; // 计算中间元素的值

            if (midValue == target) {
                return true; // 找到目标
            } else if (midValue < target) {
                l = mid + 1; // 向右移动
            } else {
                r = mid - 1; // 向左移动
            }
        }

        return false; // 没有找到目标
    }
}