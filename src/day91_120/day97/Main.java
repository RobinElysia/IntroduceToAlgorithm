package day91_120.day97;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // 保证 word1 是较短的字符串以进一步减少空间
        if (m < n) return minDistance(word2, word1);

        int[] dp = new int[n + 1];
        // 初始化第一行
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            int prev = dp[0]; // 保存左上角的值（对应 dp[i-1][j-1]）
            dp[0] = i;        // 更新 dp[i][0]
            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // 暂存当前 dp[j]，即下一轮的左上角
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prev;
                } else {
                    dp[j] = Math.min(prev, Math.min(dp[j], dp[j - 1])) + 1;
                }
                prev = temp; // 更新左上角为旧的 dp[j]
            }
        }
        return dp[n];
    }
}