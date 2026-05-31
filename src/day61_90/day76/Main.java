package day61_90.day76;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 统计频率
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // 2. 桶数组：下标 = 频率
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : freq.keySet()) {
            int f = freq.get(key);
            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(key);
        }

        // 3. 从高频率向低频率收集 k 个元素
        int[] res = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    res[idx++] = num;
                    if (idx == k) return res;
                }
            }
        }
        return res;
    }
}