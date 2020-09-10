package algorithm.queue.impl;

import algorithm.queue.IMyQueue;

public class LinkedListOfQueueImpl<E> implements IMyQueue<E> {

    private ListNode head;

    private ListNode tail;

    private int size;

    public LinkedListOfQueueImpl() {
        this.head = null;
        this.tail = null;
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
    public boolean offer(E e) {
        if (tail == null) {
            tail = new ListNode(e);
            head = tail;
        } else {
            tail.next = new ListNode(e);
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }
        return (E)head.data;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空");
        }

        ListNode res = head;
        head = head.next;
        res.next = null;
        //就有一个节点
        if(head == null){
            tail = null;
        }
        size--;
        return (E)res.data;
    }

    @Override
    public void print() {
        ListNode cur = head.next;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    private class ListNode<E> {

        public E data;

        public ListNode next;

        public ListNode(E data) {
            this.data = data;
            this.next = null;
        }

    }
}
