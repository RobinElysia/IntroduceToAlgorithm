package day61_90.day84;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) { // 没有房子可偷，返回 0
            return 0;
        }
        if (nums.length == 1) { // 只有一间房子，直接偷这间房子
            return nums[0];
        }

        int prev2 = nums[0];                 // dp[i-2] - 偷第 i-2 间房子获得的最大金额
        int prev1 = Math.max(nums[0], nums[1]); // dp[i-1] - 偷第 i-1 间房子获得的最大金额

        for (int i = 2; i < nums.length; i++) { // 从第三间房子开始迭代
            int current = Math.max(prev1, prev2 + nums[i]); // 当前房子 i 的最大金额：要么不偷当前房子，保持 prev1；要么偷当前房子，加上 prev2
            prev2 = prev1; // 更新 prev2 为 prev1，为下一轮迭代做准备
            prev1 = current; // 更新 prev1 为 current，为下一轮迭代做准备
        }
        return prev1; // 最后 prev1 存储了偷到最后一间房子时的最大金额
    }
}