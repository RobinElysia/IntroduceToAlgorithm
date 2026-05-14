package day49;

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
    private int[] preorder;
    private int[] inorder;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }

        this.preorder = preorder;
        this.inorder = inorder;
        int n = inorder.length;

        // 建立中序哈希映射：值 -> 索引
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        // 初始区间为整个数组
        return buildTreeRecursive(0, n - 1, 0, n - 1);
    }

    private TreeNode buildTreeRecursive(int preStart, int preEnd,
                                        int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal); // 创建根节点

        int rootIndex = inorderIndexMap.get(rootVal); // 获取根节点在中序遍历中的索引
        int leftSize = rootIndex - inStart; // 左子树节点个数

        // 递归构建左子树：前序区间 [preStart+1, preStart+leftSize]
        root.left = buildTreeRecursive(preStart + 1, preStart + leftSize,
                inStart, rootIndex - 1);
        // 递归构建右子树：前序区间 [preStart+leftSize+1, preEnd]
        root.right = buildTreeRecursive(preStart + leftSize + 1, preEnd,
                rootIndex + 1, inEnd);
        return root;
    }
}