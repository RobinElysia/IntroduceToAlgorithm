package day61_90.day72;

import java.util.Stack;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public String decodeString(String s) {
        Stack<Object> stack = new Stack<>();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // 将重复次数压入栈
                stack.push(k);
                k = 0;
            } else if (ch == ']') {
                // 弹出并构建字符串
                StringBuilder sb = new StringBuilder();
                // 弹出字符直到遇到数字
                while (!stack.isEmpty() && stack.peek() instanceof String) {
                    sb.insert(0, stack.pop());
                }
                // 弹出重复次数
                int repeat = (Integer) stack.pop();
                String repeated = sb.toString().repeat(repeat);
                stack.push(repeated);
            } else {
                stack.push(String.valueOf(ch));
            }
        }

        // 构建最终结果
        StringBuilder result = new StringBuilder();
        for (Object obj : stack) {
            result.append(obj);
        }
        return result.toString();
    }
}