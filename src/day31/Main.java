package day31;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

@SuppressWarnings("all")
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) { // 1链表为空
            return list2;
        }
        if (list2 == null) { // 2链表为空
            return list1;
        }
        ListNode head = new ListNode(); // 创建一个头结点
        ListNode tail = head; // 尾指针
        while (list1 != null && list2 != null) { // 1和2链表不为空
            if (list1.val < list2.val) { // 1链表小于2链表
                tail.next = list1; // 1 值添加到尾部
                list1 = list1.next; // 移动指针
            } else { // 1链表大于2链表
                tail.next = list2; // 2 值添加到尾部
                list2 = list2.next; // 移动指针
            }
            tail = tail.next; // 都需要移动尾指针
        }
        if (list1 != null) { // 1链表不为空
            tail.next = list1; // 添加剩余的链表
        } else { // 2链表不为空
            tail.next = list2; // 添加剩余的链表
        }
        return head.next; // 返回头结点的下一个节点，即合并后的链表的头结点
    }
}