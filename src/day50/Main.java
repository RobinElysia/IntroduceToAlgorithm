package day50;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        // 空路径前缀和为 0，出现 1 次（用于处理从根开始的路径）
        prefixSumCount.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currSum, int targetSum,
                    Map<Long, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }
        currSum += node.val;
        // 当前路径和为 currSum，查找是否存在前缀和 = currSum - targetSum
        int count = prefixSumCount.getOrDefault(currSum - targetSum, 0);

        // 将当前前缀和计入 map
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        // 递归左右子树
        count += dfs(node.left, currSum, targetSum, prefixSumCount);
        count += dfs(node.right, currSum, targetSum, prefixSumCount);

        // 回溯：移除当前节点对前缀和计数的影响
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);

        return count;
    }
}