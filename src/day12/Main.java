package day12;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        Solution solution = new Solution();
        int trap = solution.trap(height);
        System.out.println(trap);
    }
}

@SuppressWarnings("all")
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 2) return 0;

        int n = height.length;
        int[] leftMax = new int[height.length]; // 从左到右扫描，记录每个位置左边的最大高度
        int[] rightMax = new int[height.length]; // 从右到左扫描，记录每个位置右边的最大高度
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        rightMax[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        // 计算面积
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            if (minHeight > height[i]) {
                sum += minHeight - height[i];
            }
        }
        return sum;
    }
    public int trap2(int[] height) {
        if (height == null || height.length < 2) return 0;
        int left = 0, right = height.length - 1; // 左右指针
        int leftMax = 0, rightMax = 0; // 左右指针对应的最大高度
        int sum = 0; // 结果
        while (left <= right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                sum += leftMax - height[left];
                left++;
            }else {
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }
}