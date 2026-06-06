package day91_120.day93;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int uniquePaths(int m, int n) {
        // dp[j] 表示当前行第 j 列的路径数
        int[] dp = new int[n];

        // 初始化第一行全为 1
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }

        // 从第二行开始逐行计算
        for (int i = 1; i < m; i++) {
            // 第一列始终为 1，从第二列开始更新
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];  // 上方dp[j] + 左方dp[j-1]
            }
        }

        return dp[n - 1];
    }
}
