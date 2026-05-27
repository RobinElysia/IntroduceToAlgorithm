package day61_90.day67;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) { // 预处理，避免空数组导致的边界问题
            return res;
        }

        // 1. 查找左边界（第一个等于 target 的位置）
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;  // 收缩右边界，继续向左找
            } else {
                left = mid + 1;
            }
        }
        // 检查是否找到
        if (left >= nums.length || nums[left] != target) {
            return res;          // 没找到，直接返回 [-1, -1]
        }
        res[0] = left;

        // 2. 查找右边界（最后一个等于 target 的位置）
        // 可以从 left 开始，也可以重置为 0；这里从 0 开始，保证正确性
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;  // 收缩左边界，继续向右找
            } else {
                right = mid - 1;
            }
        }
        res[1] = right;   // 循环结束时 right 就是右边界

        return res;
    }
}