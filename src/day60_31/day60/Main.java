package day60_31.day60;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // 当字符串长度达到 2*n 时，说明已生成一个完整组合
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // 如果左括号数量小于 n，可以添加一个左括号
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // 撤销选择
        }

        // 如果右括号数量小于左括号数量，可以添加一个右括号
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // 撤销选择
        }
    }
}