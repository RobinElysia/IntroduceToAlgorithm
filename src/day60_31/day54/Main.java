package day60_31.day54;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}



class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length; // 行高
        int cols = grid[0].length; // 列长
        Queue<int[]> queue = new LinkedList<>(); // 队列存储不新鲜橘子
        int freshOranges = 0; // 新鲜橘子

        // 初始化：统计新鲜橘子，找到腐烂橘子
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // 先把最开始腐烂橘子入队
                } else if (grid[i][j] == 1) {
                    freshOranges++; // 新鲜句子数量求和
                }
            }
        }

        // 没有新鲜橘子
        if (freshOranges == 0) return 0;
        // 没有腐烂橘子但有新鲜橘子
        if (queue.isEmpty()) return -1;

        int minutes = -1; // 从-1开始，因为第一分钟只是初始腐烂橘子
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 方向数组

        while (!queue.isEmpty()) {  // 只要还有腐烂橘子需要处理
            int size = queue.size(); // 当前这一分钟有多少个腐烂橘子
            minutes++;               // 进入新的一分钟

            for (int i = 0; i < size; i++) {  // 处理这一分钟的所有腐烂橘子
                int[] pos = queue.poll();     // 取出一个腐烂橘子的坐标
                int x = pos[0], y = pos[1];   // 获取行和列

                // 检查四个方向
                for (int[] dir : dirs) {
                    int nx = x + dir[0];  // 新行 = 当前行 + 偏移
                    int ny = y + dir[1];  // 新列 = 当前列 + 偏移

                    // 如果新位置有效 且 是新鲜橘子
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;      // 让新鲜橘子腐烂
                        freshOranges--;        // 新鲜橘子计数减1
                        queue.offer(new int[]{nx, ny}); // 新腐烂的加入队列
                    }
                }
            }
        }

        return freshOranges == 0 ? minutes : -1;
    }
}