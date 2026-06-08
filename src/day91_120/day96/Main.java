package day91_120.day96;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // 让 text2 做列，确保一维数组长度较小
        if (text1.length() < text2.length()) {
            String tmp = text1; text1 = text2; text2 = tmp;
        }
        int m = text1.length(), n = text2.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int prev = 0; // 保存 dp[i-1][j-1]（左上角的值）
            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // 先保存旧的 dp[j]（即 dp[i-1][j]），它下一轮变成 prev
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        return dp[n];
    }
}