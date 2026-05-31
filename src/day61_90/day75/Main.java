package day61_90.day75;

import java.util.PriorityQueue;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 小根堆，默认就是最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 优先队列底层实现是一个小根堆

        for (int num : nums) {
            minHeap.offer(num);
            // 保持堆的大小为 k，堆中只存当前最大的 k 个元素
            if (minHeap.size() > k) {
                minHeap.poll(); // 弹出最小的，即淘汰掉较小的元素
            }
        }

        // 堆顶就是 k 个最大元素中最小的那个，即第 k 大的元素
        return minHeap.peek();
    }
}