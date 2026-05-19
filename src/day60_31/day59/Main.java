package day60_31.day59;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        // 排序后可以提前剪枝
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remain, int start,
                           List<Integer> current, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 剪枝：如果当前数字已经大于剩余值，后面更大的数字肯定也不行
            if (candidates[i] > remain) {
                break;
            }

            current.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}