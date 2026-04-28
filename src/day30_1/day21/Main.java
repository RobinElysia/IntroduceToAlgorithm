package day30_1.day21;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 0};
        int res = solution.firstMissingPositive(nums);
        System.out.println(res);
    }
}

@SuppressWarnings("all")
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 将每个正数放到正确的位置上
        for (int i = 0; i < n; i++) {
            // 当 nums[i] 在 [1, n] 范围内，且不在正确位置时，交换
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 找到第一个位置不正确的数
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}