package day61_90.day65;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 如果没有找到，left 就是应该插入的位置
        return left;
    }
}