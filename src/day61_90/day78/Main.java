package day61_90.day78;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;  // 记录遍历到当前为止的最低价格
        int maxProfit = 0;                 // 记录当前能获得的最大利润

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;           // 更新最低买入价
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice; // 更新最大利润
            }
        }
        return maxProfit;
    }
}
