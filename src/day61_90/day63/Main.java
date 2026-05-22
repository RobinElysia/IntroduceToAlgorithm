package day61_90.day63;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int n = s.length();
        // dp[i][j] 表示 s[i..j] 是否为回文串
        boolean[][] dp = new boolean[n][n];

        // 预处理回文信息
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) { // 长度小于等于2或者内部也是回文
                    dp[i][j] = true; // 只有是回文才标记为true
                }
            }
        }

        // 回溯生成所有分割方案
        backtrack(s, 0, new ArrayList<>(), result, dp); // 从索引0开始回溯
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result, boolean[][] dp) {
        if (start == s.length()) { // 已经分割到字符串末尾，添加当前路径到结果
            result.add(new ArrayList<>(path)); // 注意要创建新的列表，否则后续修改path会影响结果中的列表
            return;
        }

        for (int end = start; end < s.length(); end++) { // 尝试从start到end的子串
            if (dp[start][end]) { // 只有是回文才继续
                path.add(s.substring(start, end + 1)); // 添加当前回文子串到路径
                backtrack(s, end + 1, path, result, dp); // 继续从end + 1开始回溯
                path.remove(path.size() - 1); // 回溯，移除当前子串，尝试下一个可能的回文子串
            }
        }
    }
}