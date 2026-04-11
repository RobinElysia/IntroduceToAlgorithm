package day13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> ans = new Solution().findAnagrams(s, p);
        System.out.println(ans);
    }
}

@SuppressWarnings("all")
class Solution {
    public List<Integer> findAnagrams(String s, String p) { // s是主串，p是模式串
        int window_size = p.length(); // 窗口大小
        String p_sorted = p.chars()
                .sorted()
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString(); // 模式串排序后的字符串
        ArrayList<Integer> ans = new ArrayList<>(); // 存放结果
        for (int i = 0; i < s.length() - window_size + 1; i++) {
            String cur = s.substring(i, i + window_size)
                    .chars()
                    .sorted()
                    .collect(StringBuilder::new,
                            StringBuilder::appendCodePoint,
                            StringBuilder::append)
                    .toString(); // 当前窗口的字符串，排序后转换为字符串
            if (cur.equals(p_sorted)) { // 如果当前窗口的字符串和模式串排序后的字符串相等，说明找到了一个异位词
                ans.add(i); // 将当前窗口的起始索引加入结果列表
            }
        }
        return ans; // 返回结果列表
    }

    public List<Integer> findAnagrams2(String s, String p) {
        ArrayList ans = new ArrayList();
        if (s.length() < p.length()) { // 如果主串的长度小于模式串的长度，直接返回空列表
            return ans;
        }
        int target_size = p.length(); // 模式串的长度
        HashMap target = new HashMap(); // 存放模式串中每个字符需要的数量
        HashMap window = new HashMap(); // 存放当前窗口中每个字符
        for (int i = 0; i < target_size; i++) { // 统计模式串中每个字符的数量
            char c = p.charAt(i);
            target.put(c, (int) target.getOrDefault(c, 0) + 1); // 统计模式串中每个字符的数量
        }
        int l = 0; // 窗口的左边界
        int r = 0; // 窗口的右边界
        int count = 0; // 统计当前窗口中满足条件的字符数量
        while (r < s.length()) { // 当右边界没有超过主串的
            char c = s.charAt(r); // 当前右边界的字符
            r++; // 右边界向右移动
            if (target.containsKey(c)){
                window.put(c, (int) window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(target.get(c))) {
                    count++;
                }
            }
            while (r - l == target_size){
                if (count == target.size()){
                    ans.add(l);
                }
                char d = s.charAt(l);
                l++;
                if (target.containsKey(d)){
                    if (window.get(d).equals(target.get(d))){
                        count--;
                    }
                    window.put(d, (int) window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return ans;
    }
}