package day30_1.day4;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
    }
}

@SuppressWarnings("all")
class Solution{
    // 最长回文子串(N^2)
    public String longestPalindrome(String s) {
        // abacdfgdcaba
        // 处理特殊输入 s长度为 0、1、2的情况
        if (s == null || s.length() <= 1) return s;
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) return s;
        if (s.length() == 2 && s.charAt(0) != s.charAt(1)) return s.charAt(0)+"";
        // 输入的长度
        int length = s.length();
        boolean [][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        // 最大回文长度
        int max = 1, start = 0;
        // 状态转移方程
        for (int j = 1; j < length; j++){
            for (int i = 0; i < j; i++){ // j = 1, i = 0 | j = 2, i = 0, i = 1 ...
                if (s.charAt(i) != s.charAt(j)) dp[i][j] = false;
                // 当首位相等，并且不存在内部回文字串时，直接为true
                else if (s.charAt(i) == s.charAt(j) && i + 1 > j - 1) {
                    dp[i][j] = true;
                }
                // 在首位相同的基础上判断是否存在内部回文子串
                else if (s.charAt(i) == s.charAt(j) && i + 1 <= j - 1) {
                    dp[i][j] = dp[i+1][j-1];

                }
                if (dp[i][j] && j - i + 1 > max){ // 找到更长的回文子串
                    max = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + max);
    }

    // Manacher’s Algorithm
    public String longestPalindrome2(String s) {
        // abacdfgdcaba
        // 处理特殊输入 s长度为 0、1、2的情况
        if (s == null || s.length() < 1) return "";

        // 预处理，加特殊字符避免奇偶回文分类
        StringBuilder t = new StringBuilder("^");
        for (int i = 0; i < s.length(); i++) {
            t.append("#").append(s.charAt(i));
        }
        t.append("#$");
        char[] arr = t.toString().toCharArray();

        int[] p = new int[arr.length]; // 回文半径数组
        int center = 0, right = 0;     // 当前回文中心和右边界
        int maxLen = 0, centerIndex = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            // i 关于 center 的对称点
            int mirror = 2 * center - i;

            // 初始化 p[i]
            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            } else {
                p[i] = 0;
            }

            // 尝试扩展
            while (arr[i + 1 + p[i]] == arr[i - 1 - p[i]]) {
                p[i]++;
            }

            // 更新 center 和 right
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // 更新最大值
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        // 原始字符串中的起始索引
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}
