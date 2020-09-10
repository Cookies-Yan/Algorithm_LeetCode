package algorithm.myList.linkedList.impl;

import algorithm.myList.IMyList;
import algorithm.myList.linkedList.ILinkedList;

public class LinkedListImpl<E> implements ILinkedList<E>, IMyList<E> {

    private int size;

    private ListNode dummy;

    public LinkedListImpl() {
        this.dummy = new ListNode(0);
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int index, E data) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index 输入错误(小于0 或 大于最大已有容量)");
        }
        ListNode prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    @Override
    public boolean add(E data) {
        add(size, data);
        return true;
    }

    @Override
    public void addFirst(E data) {
        add(0, data );
    }

    @Override
    public void addLast(E data) {
        add(size, data);
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public boolean remove(E data) {
        ListNode prev = dummy;

        while (prev.next != null) {
            if (prev.next.data == data) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {

            ListNode delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return true;
        }

        return false;
    }

    @Override
    public E remove(int index) {
        // 因为从0开始，所以等于size的时候就不能删除了
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index 输入错误(小于0 或 大于最大已有容量)");
        }

        ListNode prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        ListNode delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;

        return (E) delNode.data;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index 输入错误(小于0 或 大于最大已有容量)");
        }
        ListNode cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return (E) cur.data;
    }

    @Override
    public E getFirst() {
        return get(0);
    }

    @Override
    public E getLast() {
        return get(size - 1);
    }

    @Override
    public void set(int index, E data) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index 输入错误(小于0 或 大于最大已有容量)");
        }

        ListNode cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.data = data;
    }

    @Override
    public boolean contains(E data) {
        ListNode cur = dummy.next;

        while(cur != null) {
            //泛型不能用'=='符号，需要用equals
            if(cur.data.equals(data)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void print() {
        ListNode cur = dummy.next;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    /**
     * 如果定义泛型，list类不能谢在外面，因为不能识别是不是一个泛型
     * @param <E>
     */
    private class ListNode<E> {

        public E data;

        public ListNode next;

        public ListNode(E data) {
            this.data = data;
            this.next = null;
        }

    }
}
