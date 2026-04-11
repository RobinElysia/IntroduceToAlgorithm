package day10;

import java.util.Arrays;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = solution.maxArea(height);
        System.out.println(result);
    }
}

@SuppressWarnings("all")
class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) return 0;
        int left = 0; // 左指针
        int right = height.length - 1; // 右指针
        int max = 0; // 最大容量
        // 循环
        while (left < right){
            int currentArea = Math.min(height[left], height[right]) * (right - left); // 当前容量
            max = Math.max(max, currentArea); // 更新最大容量
            // 移动较短的指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
