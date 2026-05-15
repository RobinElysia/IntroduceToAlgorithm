package day60_31.day52;

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
    TreeNode(int x) { val = x; }
}

class Solution {
    private int maxSum = Integer.MIN_VALUE;   // 全局最大路径和

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;   // 空节点的贡献为 0
        }

        // 递归计算左右子树的最大单边贡献，如果为负数则舍弃（取0）
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 以当前节点为“拐点”的路径和：左贡献 + 当前节点值 + 右贡献
        int priceNewPath = node.val + leftGain + rightGain;

        // 更新全局最大路径和
        maxSum = Math.max(maxSum, priceNewPath);

        // 返回当前节点能为父节点提供的最大单边贡献
        // 只能选择左或右一边，加上自身值
        return node.val + Math.max(leftGain, rightGain);
    }
}