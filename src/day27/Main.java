package day27;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        System.out.println(solution.reverseList(node1));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

@SuppressWarnings("all")
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;   // 前一个节点
        ListNode curr = head;   // 当前节点
        while (curr != null) {
            ListNode nextTemp = curr.next; // 暂存下一个节点
            curr.next = prev;              // 反转指针
            prev = curr;                   // 前移
            curr = nextTemp;               // 前移
        }
        return prev; // prev 最终指向原链表的尾节点（新头）
    }
}