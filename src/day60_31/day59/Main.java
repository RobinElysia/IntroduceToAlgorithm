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
        List<List<Integer>> result = new ArrayList<>(); // 存储结果的列表
        if (candidates == null || candidates.length == 0) { // 边界条件：空数组
            return result;
        }
        // 排序后可以提前剪枝
        Arrays.sort(candidates); // 排序候选数组，便于后续剪枝
        backtrack(candidates // 候选数组
                , target // 剩余目标值
                , 0  // 起始索引
                , new ArrayList<>() // 当前组合列表
                , result // 结果列表
        ); // 从索引0开始回溯
        return result;
    }

    private void backtrack(int[] candidates, int remain, int start,
                           List<Integer> current, List<List<Integer>> result) {
        if (remain == 0) { // 递归终止条件：当剩余值为0时，说明当前组合的和等于目标值
            result.add(new ArrayList<>(current)); // 将当前组合加入结果列表，注意要创建一个新的列表来存储当前组合的副本
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 剪枝：如果当前数字已经大于剩余值，后面更大的数字肯定也不行，避免负数
            if (candidates[i] > remain) {
                break;
            }

            current.add(candidates[i]); // 选择当前数字加入组合
            backtrack(candidates, remain - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}