package day30_1.day28;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        Solution solution = new Solution();
        boolean result = solution.isPalindrome(head);
        System.out.println(result); // 输出: true
    }
}

@SuppressWarnings("all")
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 使用快慢指针找到链表的中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半部分链表
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        // 比较前半部分和反转后的后半部分
        ListNode left = head;
        ListNode right = prev; // 反转后的后半部分头节点
        while (right != null) {
            if (left.val != right.val) {
                return false; // 不相等，返回 false
            }
            left = left.next;
            right = right.next;
        }
        return true; // 所有节点都相等，返回 true
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}