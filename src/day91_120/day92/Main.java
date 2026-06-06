package day91_120.day92;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, max = 0;
        int n = s.length();

        // 从左向右扫描：处理 "())" 这类右括号过剩的情况
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else right++;

            if (left == right) {
                max = Math.max(max, 2 * right); // 匹配成功，更新最大长度
            } else if (right > left) {
                left = right = 0; // 右括号过多，当前段不可能再有效，重置
            }
        }

        left = right = 0;

        // 从右向左扫描：处理 "(()" 这类左括号过剩的情况
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else right++;

            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left > right) {
                left = right = 0; // 左括号过多，重置
            }
        }

        return max;
    }
}