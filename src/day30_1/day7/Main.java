package day30_1.day7;

import java.util.*;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // [["bat"],["nat","tan"],["ate","eat","tea"]]
        Solution solution = new Solution();
        List<List<String>> lists = solution.groupAnagrams2(s);
        System.out.println(lists);
    }
}

@SuppressWarnings("all")
class Solution {
    // 字母移位词分组
    public List<List<String>> groupAnagrams1(String[] strs) {
        // 循环便利 strs 对其进行排序
        // 排序过后的 字符串 作为 key
        // 剩下则加入 value
        ArrayList<List<String>> lists = new ArrayList<>();
        if (strs.length == 0) return lists;
        HashMap<String, List<String>> stringListHashMap = new HashMap<>();
        Arrays.stream(strs).forEach(
                s -> {
                    ArrayList<String> strings = new ArrayList<>();
                    char[] news = s.toCharArray();
                    Arrays.sort(news);
                    if (stringListHashMap.containsKey(new String(news))){ // 存在 key
                        stringListHashMap.get(new String(news)).add(s); // 获取 value 并添加 s
                    } else { // 不存在 key
                        strings.add(s); // 添加 s
                        stringListHashMap.put(new String(news), strings); // 添加 key value
                    }
                }
        );
        stringListHashMap.forEach((s, strings) -> lists.add(strings));
        return lists;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        // 优化
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // 使用字符数组排序的方式，更简洁高效
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // 使用 computeIfAbsent 简化代码
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
            // 如果 key 不存在，则创建一个新的 ArrayList，并添加 s；如果 key 已存在，则直接添加 s
        }

        return new ArrayList<>(map.values());
    }
}