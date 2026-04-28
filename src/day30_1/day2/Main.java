package day30_1.day2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RobinElysia
 * @version 1.0
 */
@SuppressWarnings("all")
public class Main {
}

@SuppressWarnings("all")
class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0); // 创建一个结果链表
        ListNode current = l3; // 当前节点
        int carry = 0; // 进位
        while (l1 != null || l2 != null || carry != 0){ // 有一个为真的时候就继续循环
            int sum = carry; // 起始于进位值
            if (l1 != null) {
                sum += l1.val; // 获取当前节点的值
                l1 = l1.next; // 移动当前节点
            }
            if (l2 != null) {
                sum += l2.val; // 获取当前节点的值
                l2 = l2.next; // 移动当前节点
            }
            carry = sum / 10; // 计算新的进位
            current.next = new ListNode(sum % 10); // 创建一个节点, 并添加进结果链表
            current = current.next; // 移动当前节点
        }
        return l3.next;
    }

    public int lengthOfLongestSubstring(String s) {
        // abcabcbb
        // pwwkew
        // aab
//        if (s == null || s.length() == 0) return 0;
//
//        int length = 0;
//        int max = 0;
//        int left = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (!map.containsKey(s.charAt(i))){ // 如果链表中不包含当前元素
//                map.put(s.charAt(i), i);
//                length++;
//                max = Math.max(max, length);
//                continue;
//            } else { // 链表中包含当前元素
//
//                map.remove(s.charAt(left));
//                left += 1;
//                i -= 1;
//                length -= 1;
//                continue;
//            }
//        }
//        return max;

        // aababbbaabac
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                left = charIndexMap.get(currentChar) + 1;
            }
            charIndexMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}