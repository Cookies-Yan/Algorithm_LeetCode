package algorithm.queue.impl;

import algorithm.queue.IMyQueue;

/**
 * 循环队列
 * @param <E>
 */
public class ArrayCircularOfQueueImpl<E> implements IMyQueue<E> {

    private E[] data;

    private int head;

    private int tail;

    public ArrayCircularOfQueueImpl() {
        this(10);
    }

    public ArrayCircularOfQueueImpl(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public int size() {
        return (tail - head + data.length) % data.length;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean offer(E e) {
        data[tail] = e;
        if ((tail = (tail + 1) % data.length) == head) {
                resize(data.length * 2);
        }
        return false;
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
        E obj = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        return obj;
    }

    @Override
    public void print() {
        System.out.println("Size : " + size());
        System.out.println("capacity : " + data.length);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");

        }
    }

    public void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[(i + head) % data.length];
        }
        head = 0;
        tail = data.length;
        data = temp;
    }
}
