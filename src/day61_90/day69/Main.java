package day61_90.day69;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 比较 mid 和 right，确定最小值在哪一半
            if (nums[mid] > nums[right]) {
                // 断崖在右半部分，最小值在 mid 右边
                left = mid + 1;
            } else {
                // nums[mid] < nums[right]：断崖在左半部分（含 mid）
                // nums[mid] == nums[right]：无法判断，收缩右边界
                right = mid;
            }
        }

        return nums[left];
    }
}