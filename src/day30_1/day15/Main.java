package day30_1.day15;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Solution solution = new Solution();
        int[] result = solution.maxSlidingWindow(nums, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

@SuppressWarnings("all")
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        // 双端队列存储数组下标，保证队首始终是当前窗口最大值的索引
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // 移除队列尾部所有小于当前元素的值（它们不可能成为后续窗口的最大值）
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // 当前元素索引入队
            deque.offerLast(i);

            // 如果队首元素已经滑出窗口，则移除
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 当窗口形成后（i >= k-1），记录当前窗口最大值
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}