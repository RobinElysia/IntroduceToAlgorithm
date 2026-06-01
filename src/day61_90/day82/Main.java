package day61_90.day82;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int climbStairs(int n) {
        // 基础情况：如果 n <= 2，直接返回 n
        if (n <= 2) {
            return n;
        }

        // 初始化前两个状态
        int first = 1;  // 爬到第1级的方法数
        int second = 2; // 爬到第2级的方法数
        int result = 0;

        // 从第3级开始迭代计算
        for (int i = 3; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }
}