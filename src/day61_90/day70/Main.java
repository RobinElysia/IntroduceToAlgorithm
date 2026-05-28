package day61_90.day70;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public boolean isValid(String s) {
        // 奇数长度直接判否
        if (s.length() % 2 == 1) return false;

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // 左括号入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // 右括号但栈空，不匹配
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                // 检查是否配对
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        // 栈必须为空，说明全部匹配
        return stack.isEmpty();
    }
}