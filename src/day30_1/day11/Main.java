package day30_1.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
            int[] nums = {-1, 0, 1, 2, -1, -4};
            Solution solution = new Solution();
            List<List<Integer>> lists = solution.threeSum(nums);
            System.out.println(lists);
    }
}

@SuppressWarnings("all")
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums); // 排序，便于去重和双指针移动
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            // 跳过重复的第一个数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 跳过重复的 left 和 right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}