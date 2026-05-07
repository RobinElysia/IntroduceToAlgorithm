package day42;

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
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    // 计算节点高度（边数），同时更新直径
    private int height(TreeNode node) {
        if (node == null) return 0;
        int leftH = height(node.left);
        int rightH = height(node.right);
        // 经过当前节点的路径长度 = 左高 + 右高（边数）
        diameter = Math.max(diameter, leftH + rightH);
        // 返回当前节点的高度
        return 1 + Math.max(leftH, rightH);
    }
}