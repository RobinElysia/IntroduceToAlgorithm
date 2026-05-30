package day61_90.day74;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}


class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int[] stack = new int[n + 1];  // 多一个空间给哨兵
        int top = -1;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i]; // 这是为了在最后处理完所有柱子时，能够计算出剩余柱子的面积

            while (top >= 0 && currentHeight < heights[stack[top]]) {
                int height = heights[stack[top--]];
                int width = (top == -1) ? i : i - stack[top] - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack[++top] = i; // 将当前柱子的索引入栈
        }

        return maxArea;
    }
}