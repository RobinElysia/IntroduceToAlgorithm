package day61_90.day87;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示凑出金额 i 所需的最少硬币数
        int[] dp = new int[amount + 1];
        // 初始化为一个不可能的大数（amount + 1 即可）
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        // 金额 0 需要 0 枚硬币
        dp[0] = 0;

        // 遍历每个金额
        for (int i = 1; i <= amount; i++) {
            // 尝试使用每种硬币
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 如果无法凑出，返回 -1；否则返回最少硬币数
        return dp[amount] > amount ? -1 : dp[amount];
    }
}