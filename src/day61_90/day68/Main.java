package day61_90.day68;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 判断左半部分是否有序
            if (nums[left] <= nums[mid]) {
                // 左半有序，判断 target 是否在左半区间内
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;  // 在左半部分
                } else {
                    left = mid + 1;   // 去右半部分
                }
            } else {
                // 右半有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;   // 在右半部分
                } else {
                    right = mid - 1;  // 去左半部分
                }
            }
        }
        return -1;
    }
}