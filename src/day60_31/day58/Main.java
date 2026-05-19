package day60_31.day58;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    // 数字到字母的映射
    private static final String[] KEYBOARD = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        // 边界条件：空字符串
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // 递归终止条件：已经处理完所有数字
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // 获取当前数字对应的字母字符串
        int digit = digits.charAt(index) - '0';
        String letters = KEYBOARD[digit];

        // 遍历当前数字对应的每个字母
        for (char letter : letters.toCharArray()) {
            current.append(letter);           // 选择
            backtrack(digits, index + 1, current, result);  // 递归
            current.deleteCharAt(current.length() - 1);     // 撤销选择
        }
    }
}