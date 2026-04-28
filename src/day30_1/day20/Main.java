package day30_1.day20;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] res = solution.productExceptSelf(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

@SuppressWarnings("all")
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pre[] = new int[nums.length]; // 前缀积
        int back[] = new int[nums.length]; // 后缀积
        int res[] = new int[nums.length]; // 结果数组
        pre[0] = 1; // 前缀积的第一个元素为 1
        back[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++){ // 获取前缀积
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) { // 获取后缀积
            back[i] = back[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre[i] * back[i]; // 结果数组的每个元素等于前缀积和后缀积的乘积
        }
        return res;
    }
}