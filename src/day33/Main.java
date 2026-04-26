package day33;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        ListNode result = solution.swapPairs(head);

        // Print the resulting linked list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

@SuppressWarnings("all")
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 创建虚拟头节点，简化边界处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            // 定义要交换的两个节点
            ListNode first = prev.next;
            ListNode second = first.next;

            // 进行交换
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // 移动prev到下一组的前一个位置
            prev = first;
        }

        return dummy.next;
    }
}