package leetCode.design_17;

import java.util.HashMap;

public class M_146_LRUCache {
    /**
     * HashMap + Double Linked List (删除需要知道prev节点)
     *
     * 需要O(1)操作的话，ArrayList不能满足
     * Time O(1)
     *
     * 插入： 1. 不存在
     *       2. 存在
     * 取出： 1.不存在
     *       2.存在
     * 排序
     *
     * map: 3,(3,3)
     *      2,(2,4)
     */
    class Node {
        int key;
        int value;
        Node next;
        Node pre;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public M_146_LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        if (node != tail) { //不是最近加入的值， 不等于空 要更新排序,等于尾部不需要排序
            if (node == head) {
                head = head.next;
            } else {
                /**
                 * h
                 * 2,4 -> 3,3 -> 5,5 -> null
                 * 没有很好的理解
                 */
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            if (node != tail) { //不是最近加入的值
                if (node == head) {
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
        } else {
            Node newNode = new Node(key, value);
            if (capacity == 0) {
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capacity++;
            }
            if (head == null && tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }
    }

}
