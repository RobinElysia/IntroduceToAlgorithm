package day30_1.day3;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1,2,3,4,5},new int[]{6,7,8,9,10,11,12,13,14,15,16}));
    }
}

@SuppressWarnings("all")
class Solution{
    // 寻找两个有序数组的中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保nums1是较短的数组，这样我们可以减少二分查找的范围
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;  // 较短数组的长度
        int n = nums2.length;  // 较长数组的长度
        int low = 0, high = m; // 二分查找的初始边界
        // 计算左半部分应有的元素总数（向上取整，确保左半部分可以比右半部分多一个元素）
        int totalLeft = (m + n + 1) / 2;

        // 开始二分查找
        while (low <= high) {
            // 在nums1中确定分割点i（将nums1分为[0, i-1]和[i, m-1]两部分）
            int i = (low + high) / 2;
            // 根据i计算nums2中的分割点j（左半部分总元素数为totalLeft）
            int j = totalLeft - i;

            // 处理边界情况：当i=0时，nums1左半部分为空，使用最小整数值表示
            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            // 当i=m时，nums1右半部分为空，使用最大整数值表示
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];
            // 当j=0时，nums2左半部分为空，使用最小整数值表示
            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            // 当j=n时，nums2右半部分为空，使用最大整数值表示
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // 检查分割是否正确：nums1左半部分的最大值应小于等于nums2右半部分的最小值
            // 且nums2左半部分的最大值应小于等于nums1右半部分的最小值
            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                // 如果总长度为奇数，中位数为左半部分的最大值
                if ((m + n) % 2 == 1) {
                    return Math.max(nums1Left, nums2Left);
                } else {
                    // 如果总长度为偶数，中位数为左半部分最大值和右半部分最小值的平均值
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                }
            } else if (nums1Left > nums2Right) {
                // 如果nums1左半部分的最大值大于nums2右半部分的最小值
                // 说明分割点i太大，需要在左半部分继续查找
                high = i - 1;
            } else {
                // 否则，分割点i太小，需要在右半部分继续查找
                low = i + 1;
            }
        }
        // 理论上应该总能找到解，这里抛出异常以防万一
        throw new IllegalArgumentException("No solution found");
    }
}
