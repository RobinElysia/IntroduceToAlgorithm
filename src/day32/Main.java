package day32;

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
        ListNode result = solution.removeNthFromEnd(head, 2);

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); // 创建一个虚拟节点
        dummy.next = head; // 将虚拟节点的next指向head
        ListNode first = dummy; // 定义两个指针，first和second
        ListNode second = dummy; // second指针先指向虚拟节点

        // Move first n+1 steps ahead
        for (int i = 0; i <= n; i++) { // 移动first指针n+1步
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while (first != null) { // 移动first和second指针，直到first指针到达链表的末尾
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from the end
        second.next = second.next.next; // second指针的next指向second.next.next，跳过要删除的节点

        return dummy.next; // 返回虚拟节点的next，即链表的头节点
    }
}