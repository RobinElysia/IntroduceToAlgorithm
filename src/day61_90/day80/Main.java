package day61_90.day80;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;   // 已经在终点，不需要跳跃
        }

        int steps = 0;          // 跳跃次数
        int curEnd = 0;        // 当前步数能到达的最远边界
        int maxReach = 0;      // 下一步能到达的最远位置

        // 注意：不需要访问最后一个元素，因为在到达终点的前一步就已经确定了
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            // 已经到达当前步数的边界，必须再跳一次
            if (i == curEnd) {
                steps++;
                curEnd = maxReach;

                // 如果新的边界已经覆盖终点，提前结束
                if (curEnd >= nums.length - 1) {
                    return steps;
                }
            }
        }
        return steps;
    }
}