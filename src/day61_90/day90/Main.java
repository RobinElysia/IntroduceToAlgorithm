package day61_90.day90;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 维护最大值和最小值（因为负数乘以负数可能变成最大值）
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 保存当前最大值，因为更新时会被覆盖
            int tempMax = maxSoFar;
            // 当前最大值可能来自：前一个最大值*当前数，前一个最小值*当前数，当前数本身
            maxSoFar = Math.max(Math.max(tempMax * nums[i], minSoFar * nums[i]), nums[i]);
            // 当前最小值同理
            minSoFar = Math.min(Math.min(tempMax * nums[i], minSoFar * nums[i]), nums[i]);
            // 更新全局最大值
            result = Math.max(result, maxSoFar);
        }
        return result;
    }
}