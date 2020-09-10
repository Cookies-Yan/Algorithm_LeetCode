package algorithm.queue.impl;

import algorithm.queue.IMyQueue;

public class ArrayOfQueueImpl<E> implements IMyQueue<E> {

    private E[] data;

    private int head;

    private int tail;

    private int size;

    public ArrayOfQueueImpl() {
        this(10);
    }

    public ArrayOfQueueImpl(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.tail = 0;
        this.head = 0;
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
        if (tail == data.length) {
            resize(data.length * 2);
        }
        data[tail++] = e;
        size++;
        return true;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new  IllegalArgumentException("队列为空");
        }
        return data[head];
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new  IllegalArgumentException("队列为空");
        }
        E obj = data[head++];
        if (head == data.length) {
            head = 0;
        }
        size--;
        return obj;
    }

    @Override
    public void print() {
        System.out.println("Size : " + size);
        System.out.println("capacity : " + data.length);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");

        }
    }

    public void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < tail; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
