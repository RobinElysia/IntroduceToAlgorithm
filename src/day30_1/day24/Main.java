package day30_1.day24;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new Solution().rotate(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}

@SuppressWarnings("all")
class Solution {
    public void rotate(int[][] matrix) {
        int lup = 0, rup = matrix.length - 1; // 左上角, 右上角
        while (lup < rup){
            for (int i = 0; i < rup - lup; i++){ // 每层旋转次数
                int top = lup, bottom = rup; // 当前层的上下边界
                int temp = matrix[top][lup + i]; // 暂存左上角的元素
                matrix[top][lup + i] = matrix[bottom - i][lup]; // 把左下角的元素放到左上角
                matrix[bottom - i][lup] = matrix[bottom][rup - i]; // 把右下角的元素放到左下角
                matrix[bottom][rup - i] = matrix[top + i][rup]; // 把右上角的元素放到右下角
                matrix[top + i][rup] = temp; // 把暂存元素放到右上角
            }
            lup++;
            rup--; // 缩圈操作
        }
    }
}