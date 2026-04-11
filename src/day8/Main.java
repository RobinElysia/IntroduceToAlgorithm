package day8;

import java.util.HashSet;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.longestConsecutive(new int[]{1,2,6,7,8});
        System.out.println(i);
    }
}

@SuppressWarnings("all")
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        // 定义最大值
        int max = 1;
        // 定义哈希set
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // 定义起始元素哈希
        HashSet<Integer> StartSet = new HashSet<>();
        // 循环数组
        for (int i = 0; i < nums.length; i++){
            if (!set.contains(nums[i] - 1)){ // 如果 num[i]-1 元素不在集合中
                // 那么这个start就是起始位置
                StartSet.add(nums[i]);
            }
        }
        for (int start : StartSet){ // 从开始位置+1找最大
            int i = 1;
            while (set.contains(start)) { // 当start 在集合中时，start+1
                start++;
                max = Math.max(max, i++);
            }
        }
        return max;
    }

    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {  // 直接遍历set，避免重复处理
            // 只有当当前数字是序列的起点时才处理
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                max = Math.max(max, currentLength);
            }
        }
        return max;
    }
}