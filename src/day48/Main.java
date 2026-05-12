package day48;

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
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left); // 递归
        flatten(root.right); // 递归
        // 左树转右树
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        // 旧右树嫁接新右树
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        // 嫁接
        cur.right = temp;
    }
}