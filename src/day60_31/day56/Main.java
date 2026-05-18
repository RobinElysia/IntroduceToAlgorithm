package day60_31.day56;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int start) {
        // 到达末尾，保存当前排列
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) list.add(num);
            res.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);                     // 将第 i 个元素交换到当前位置
            backtrack(res, nums, start + 1);          // 递归处理下一个位置
            swap(nums, start, i);                     // 回溯，恢复原数组
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}