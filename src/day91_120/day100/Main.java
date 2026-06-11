package day91_120.day100;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1, i = 0;
        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i++, p0++);
            } else if (nums[i] == 2) {
                swap(nums, i, p2--);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}