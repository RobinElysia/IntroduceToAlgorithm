package day30_1.day16;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t));
    }
}

@SuppressWarnings("all")
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        // need 数组记录 t 中每个字符的需求数量（ASCII 128 足够）
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        // 统计 t 中不同字符的种类数（需求种类数）
        int required = 0;
        for (int count : need) {
            if (count > 0) required++;
        }
        // window 数组记录当前窗口中各字符的出现次数
        int[] window = new int[128];
        int left = 0, right = 0;          // 窗口左右边界（左闭右开）
        int formed = 0;                   // 当前窗口中已经满足需求种类的字符数
        int minLen = Integer.MAX_VALUE;   // 最小窗口长度
        int start = 0;                    // 最小窗口的起始索引
        while (right < s.length()) {
            // 扩大右边界，加入字符 c
            char c = s.charAt(right);
            window[c]++;
            // 如果该字符是 t 中需要的，并且数量刚好满足需求，则 formed 加 1
            if (need[c] > 0 && window[c] == need[c]) {
                formed++;
            }
            // 当窗口已经包含所有 t 中的字符时，尝试收缩左边界以找到最小窗口
            while (left <= right && formed == required) {
                // 更新最小窗口信息
                int curLen = right - left + 1;
                if (curLen < minLen) {
                    minLen = curLen;
                    start = left;
                }
                // 移除左边界字符
                char leftChar = s.charAt(left);
                window[leftChar]--;
                // 如果移除的字符是 t 中需要的，并且移除后数量不满足需求，则 formed 减 1
                if (need[leftChar] > 0 && window[leftChar] < need[leftChar]) {
                    formed--;
                }
                left++; // 左边界右移
            }
            right++; // 继续扩大右边界
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}