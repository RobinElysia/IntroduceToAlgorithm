package day61_90.day88;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i] 表示 s[0..i-1] 能否被拆分
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // 空串可被拆分

        // 用 HashSet 加速查找，O(1) 判断单词是否在字典中
        Set<String> wordSet = new HashSet<>(wordDict);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // 如果 s[0..j-1] 可被拆分，且 s[j..i-1] 在字典中
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // 找到一个可行拆分即可，提前退出
                }
            }
        }

        return dp[n];
    }
}