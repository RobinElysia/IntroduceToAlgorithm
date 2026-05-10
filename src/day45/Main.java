package day45;

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
    // 使用 Long 最小值防止节点值为 Integer.MIN_VALUE 的边界问题
    private long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }

        // 访问当前节点：必须大于前一个节点
        if (root.val <= prev) {
            return false;
        }
        prev = root.val;

        // 访问右子树
        return isValidBST(root.right);
    }
}