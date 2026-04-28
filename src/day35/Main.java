package day35;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

// 随机链表节点定义
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

@SuppressWarnings("all")
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 第一步：在每个原节点后面创建一个新节点
        // 原链表：1 -> 2 -> 3
        // 变成：1 -> 1' -> 2 -> 2' -> 3 -> 3'
        Node cur = head;
        while (cur != null) {
            // 创建新节点
            Node newNode = new Node(cur.val);
            // 新节点的next指向原节点的next
            newNode.next = cur.next;
            // 原节点的next指向新节点
            cur.next = newNode;
            // cur移动到下一个原节点
            cur = newNode.next;
        }

        // 第二步：设置新节点的random指针
        // 新节点的random = 原节点random的next（即random对应的复制节点）
        cur = head;
        while (cur != null) {
            // cur.next就是当前原节点对应的复制节点
            if (cur.random != null) {
                // 复制节点的random指向原节点random对应的复制节点
                cur.next.random = cur.random.next;
            }
            // cur移动到下一个原节点（跳过一个复制节点）
            cur = cur.next.next;
        }

        // 第三步：将两个链表分离
        // 需要将原链表恢复，同时提取出复制链表
        cur = head;
        Node dummy = new Node(0); // 新链表的虚拟头节点
        Node newCur = dummy;      // 用于构建新链表的指针

        while (cur != null) {
            // 将复制节点连接到新链表中
            newCur.next = cur.next;
            newCur = newCur.next;

            // 恢复原链表的next指针
            cur.next = cur.next.next;

            // cur移动到下一个原节点
            cur = cur.next;
        }

        // 返回新链表的头节点
        return dummy.next;
    }
}