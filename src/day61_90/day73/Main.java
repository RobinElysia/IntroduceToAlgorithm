package day61_90.day73;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution solution = new Solution();
        int[] result = solution.dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n]; // 初始化答案数组，默认值为0
        int[] stack = new int[n];  // 用数组模拟栈
        int top = -1;  // 栈顶指针

        for (int i = 0; i < n; i++) {
            while (top >= 0 && temperatures[i] > temperatures[stack[top]]) { // 第一遍会跳过，因为栈顶元素是0，温度不大于当前温度
                // 当前温度大于栈顶索引对应的温度，说明找到了一个更高的温度
                int prevIndex = stack[top--]; // 弹出栈顶元素，获取之前的索引
                answer[prevIndex] = i - prevIndex; // 计算当前索引与之前索引的差值，表示等待的天数
            }
            stack[++top] = i; // 将当前索引入栈
        }
        return answer;
    }
}