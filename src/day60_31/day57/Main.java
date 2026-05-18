package day60_31.day57;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path,
                           int[] nums, int start) {
        // 每个节点都代表一个子集，直接加入结果
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);                      // 选择当前元素
            backtrack(res, path, nums, i + 1);      // 从 i+1 开始，避免重复
            path.remove(path.size() - 1);           // 回溯，撤销选择
        }
    }
}