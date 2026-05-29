package day61_90.day71;

import java.util.Stack;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class MinStack {
    private Stack<Integer> stack;      // 主栈
    private Stack<Integer> minStack;   // 辅助栈，存储最小值

    public MinStack() { // 构造函数初始化两个栈
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // 如果辅助栈为空或当前值小于等于辅助栈顶，则压入辅助栈
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        // 如果弹出的值等于当前最小值，辅助栈也要弹出
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}