package day61_90.day79;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public boolean canJump(int[] nums) {
        // 维护当前能够到达的最远位置
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            // 如果当前位置已经超过了最远可达位置，说明无法到达此位置
            if (i > maxReach) {
                return false;
            }
            // 更新最远可达位置：当前位置 + 能跳的最大距离
            maxReach = Math.max(maxReach, i + nums[i]);
            // 提前结束：如果最远可达位置已经能覆盖终点，直接返回 true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}