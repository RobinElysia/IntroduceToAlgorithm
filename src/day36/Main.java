package day36;

import java.util.PriorityQueue;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = {listNode1, listNode2, listNode3};
        Solution solution = new Solution();
        ListNode result = solution.mergeKLists(lists);
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // 创建最小堆，按照节点值排序
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 将每个链表的头节点加入优先队列
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // 从优先队列中取出最小节点，将其连接到结果链表
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;

            // 如果取出的节点还有下一个节点，将其加入优先队列
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}