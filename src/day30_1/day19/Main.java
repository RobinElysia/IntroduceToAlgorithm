package day30_1.day19;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

@SuppressWarnings("all")
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1); // 先反转整个数组
        reverse(nums, 0, k - 1); // 再反转前 k 个元素
        reverse(nums, k, nums.length - 1); // 再反转后 k 个元素
    }

    public void reverse(int[] nums, int start, int end) { // 反转函数
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}