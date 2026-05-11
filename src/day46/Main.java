package day46;

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
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    private void traverse(TreeNode node, int k) {
        if (node == null || count >= k) return;

        // 1. 遍历左子树
        traverse(node.left, k);

        // 2. 访问当前节点
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // 3. 遍历右子树
        traverse(node.right, k);
    }
}