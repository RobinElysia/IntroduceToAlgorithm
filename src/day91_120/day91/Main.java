package day91_120.day91;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 总和为奇数直接返回false
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        // 一维DP数组
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            // 必须从后往前遍历，避免重复使用
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}