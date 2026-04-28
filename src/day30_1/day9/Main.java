package day30_1.day9;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,0,3,12};
        solution.moveZeroes(nums);
    }
}

@SuppressWarnings("all")
class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0; // 指向下一个非零元素应该放置的位置

        // 第一遍：将所有非零元素移到前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        // 第二遍：将剩余位置填充为0
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}