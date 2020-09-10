package leetCode.design_17;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class H_432_AllOOneDataStructure {
    class Node {
        int val;
        LinkedHashSet<String> keys;
        Node pre;
        Node next;
        public Node(int val) {
            this.val = val;
            this.keys = new LinkedHashSet<>();
        }
    }

    HashMap<String, Node> map;
    Node head;
    Node tail;

    /** Initialize your data structure here. */
    public H_432_AllOOneDataStructure() {
        this.map = new HashMap<>();
        this.head = new Node(-1);
        this.tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
    }

    public void addNext(Node cur, Node next) {
        next.pre = cur;
        next.next = cur.next;
        cur.next.pre = next;
        cur.next = next;
    }

    public void addPre(Node cur, Node pre) {
        pre.next = cur;
        pre.pre = cur.pre;
        cur.pre.next = pre;
        cur.pre = pre;
    }

    public void removeNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        //之前加过和没加过两种情况
        if (map.containsKey(key)) {
            //又分有节点和没节点两种
            Node curNode = map.get(key);
            int curVal = curNode.val;
            Node nextNode;
            if (curNode.next.val == curVal + 1) {
                nextNode = curNode.next;
                nextNode.keys.add(key);
            } else {
                nextNode = new Node(curVal + 1);
                nextNode.keys.add(key);
                addNext(curNode, nextNode);
            }
            curNode.keys.remove(key);
            if (curNode.keys.size() == 0) {
                removeNode(curNode);
            }
            map.put(key, nextNode);
        } else {
            //又分有节点和没节点两种
            if (head.next.val == 1) {
                head.next.keys.add(key);
                map.put(key, head.next);
            } else {
                Node cur = new Node(1);
                cur.keys.add(key);
                addNext(head, cur);
                map.put(key, cur);
            }
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {

        if (map.containsKey(key)) {
            Node curNode = map.get(key);
            int curVal = curNode.val;
            if (curVal == 1) {
                curNode.keys.remove(key);
                if (curNode.keys.size() == 0) {
                    removeNode(curNode);
                }
                map.remove(key);
            } else {
                Node preNode;
                if (curNode.pre.val == curVal - 1) {
                    preNode = curNode.pre;
                    preNode.keys.add(key);
                } else {
                    preNode = new Node(curVal - 1);
                    preNode.keys.add(key);
                    addPre(curNode, preNode);
                }
                curNode.keys.remove(key);
                if (curNode.keys.size() == 0) {
                    removeNode(curNode);
                }
                map.put(key, preNode);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail.pre == head) {
            return "";
        } else {
            return tail.pre.keys.iterator().next(); //next() 只打印出来一个
        }
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        } else {
            return head.next.keys.iterator().next(); //next() 只打印出来一个
        }

    }
}
