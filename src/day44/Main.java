package day44;

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

class SortedArrayToBST {

    /**
     * 将有序数组转换为高度平衡的二叉搜索树
     *
     * @param nums 升序整数数组
     * @return 二叉搜索树的根节点
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }

    /**
     * 递归构建 BST
     *
     * @param nums  有序数组
     * @param left  当前区间的左边界
     * @param right 当前区间的右边界
     * @return 当前子树根节点
     */
    private TreeNode buildBST(int[] nums, int left, int right) {
        // 递归终止条件：区间无效
        if (left > right) {
            return null;
        }

        // 选取中间位置作为根（总是选择靠左的中间元素，避免整数溢出）
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // 递归构建左右子树
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }
}
