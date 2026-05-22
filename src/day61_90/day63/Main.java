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
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        // 回溯生成所有分割方案
        backtrack(s, 0, new ArrayList<>(), result, dp);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result, boolean[][] dp) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) { // 只有是回文才继续
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path, result, dp);
                path.remove(path.size() - 1);
            }
        }
    }
}