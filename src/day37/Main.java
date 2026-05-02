package day37;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RobinElysia
 * @version 1.0
 */
public class Main {
}

@SuppressWarnings("all")
class LRUCache {
    // 双向链表节点
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache; // 哈希表
    private int capacity;             // 最大容量
    private int size;                 // 当前大小
    private Node head;               // 虚拟头节点
    private Node tail;               // 虚拟尾节点

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        cache = new HashMap<>();

        // 初始化虚拟头尾节点
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 移动到链表头部（最近使用）
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            // 创建新节点
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;

            if (size > capacity) {
                // 删除最久未使用的节点
                Node removed = removeTail();
                cache.remove(removed.key);
                size--;
            }
        } else {
            // 更新已有节点的值
            node.value = value;
            moveToHead(node);
        }
    }

    // 辅助方法
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}