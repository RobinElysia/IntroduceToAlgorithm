package day61_90.day81;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

class Solution {
    public List<Integer> partitionLabels(String s) {
        // 1. 记录每个字母最后出现的位置
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0, end = 0; // 当前片段的起始和结束位置

        // 2. 遍历字符串，划分片段
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']); // 扩展当前片段的右边界
            if (i == end) { // 当前位置就是当前片段的右边界，进行一次划分
                result.add(end - start + 1);
                start = i + 1; // 下一个片段的起始位置
            }
        }
        return result;
    }
}