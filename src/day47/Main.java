package day47;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // 根节点入队

        while (!queue.isEmpty()) {
            int size = queue.size(); // 当前层的节点数
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // 队头节点出队(一般来说先是左节点)
                // 如果是当前层的最后一个节点，加入结果集
                if (i == size - 1) { // 当前层最后一个节点（也就是右侧节点
                    res.add(node.val); // 添加当前右节点的值到结果集
                } // 如果左树的深度大于右树的深度，则右树没有节点，则当前节点的右节点为null，我们判断最后一个节点为左节点
                // 标准层序遍历：先左后右入队
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }
}