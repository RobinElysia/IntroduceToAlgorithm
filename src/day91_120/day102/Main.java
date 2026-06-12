package day91_120.day102;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]);
            if (nums[idx] < 0) {
                return idx;  // 已经变负，说明 idx 重复出现
            }
            nums[idx] = -nums[idx];  // 标记为已访问
        }
        return -1; // 不会走到这里
    }
}