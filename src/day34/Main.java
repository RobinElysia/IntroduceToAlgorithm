package day34;

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
        ListNode result = solution.reverseKGroup(head, 2);

        // Print the reversed list
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

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 空链表或k<=1（即无需翻转）时，直接返回原链表
        if (head == null || k <= 1) {
            return head;
        }

        // 哑节点，作为伪头，方便处理边界（即便翻转首组，前驱节点也始终存在）
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // prevGroupEnd 标记「上一组翻转后的尾节点」，初始时指向哑节点
        ListNode prevGroupEnd = dummy;

        while (true) {
            // 1. 找到当前组的第 k 个节点（kthNode）
            ListNode kthNode = prevGroupEnd;
            for (int i = 0; i < k && kthNode != null; i++) {
                kthNode = kthNode.next;
            }
            // 如果剩余节点不够 k 个，不再翻转，直接结束
            if (kthNode == null) {
                break;
            }

            // 2. 标记当前组的起点和下一组的起点
            ListNode groupStart = prevGroupEnd.next;      // 当前组的第一个节点
            ListNode nextGroupStart = kthNode.next;       // 下一组的第一个节点（可能为 null）

            // 3. 翻转当前组 [groupStart ... kthNode]
            ListNode prev = nextGroupStart;   // 翻转后，原组头要指向下一组的开头
            ListNode current = groupStart;
            // 当 current 移动到 nextGroupStart 时，说明组内节点已全部翻转完毕
            while (current != nextGroupStart) {
                ListNode tempNext = current.next; // 暂存下一个节点
                current.next = prev;              // 反转指向
                prev = current;                   // prev 前移
                current = tempNext;               // current 前移
            }
            // 循环结束时，prev 就是翻转后的组头（原来的 kthNode）

            // 4. 将上一组与当前翻转后的组连接
            prevGroupEnd.next = kthNode;  // 上一组尾节点 -> 翻转后的组头
            // groupStart 现在变成了当前组的尾节点，成为新的 prevGroupEnd
            prevGroupEnd = groupStart;
        }

        // 返回新的头节点
        return dummy.next;
    }
}