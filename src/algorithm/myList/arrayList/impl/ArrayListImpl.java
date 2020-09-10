package algorithm.myList.arrayList.impl;

import algorithm.myList.IMyList;
import algorithm.myList.arrayList.IArrayList;

/**
 *
 */
public class ArrayListImpl<E> implements IArrayList<E>, IMyList<E> {

    private E[] data;

    private int size;

    public ArrayListImpl(int capacity) {
        /**
         * 标准泛型定义数组
         */
        this.data = (E[])new Object[capacity];
        this.size = 0;
    }

    public ArrayListImpl() {
        this(10);
    }

    /**
     * 时间O(1)
     * @return
     */
    @Override
    public int capacity() {
        return data.length;
    }

    /**
     * 时间O(1)
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 时间O(1)
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 时间O(n)
     * 调用了下面的add,最坏的情况，最坏从头(n),最好从尾(1) 平均(1/2n) = O(n)
     * 在java源码中是O(1)
     * @return
     */
    @Override
    public boolean add(E element) {
        add(size, element);
        return true;
//        if (size == data.length) {
//            throw new IllegalArgumentException("数组已满");
//        }
//        data[size] = element;
//        size++;
    }

    /**
     * 时间O(n)
     * @return
     */
    @Override
    public void add(int index, E element) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("数组已满");
//        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index 输入错误");
        }

        if (size == data.length) {
            resize(data.length * 2);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];

        }
        data[index] = element;
        size++;
    }

    /**
     * 时间O(n)
     * @return
     */
    @Override
    public boolean contains(E element) {

        //小于size不是data.length，因为元素不一定沾满了数组
        for (int i = 0; i < size; i++) {

            if(data[i] == element) return true;
            
        }
        return false;
    }

    /**
     * 时间O(1)
     * @return
     */
    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index 输入错误");
        }
        return data[index];
    }

    /**
     * 时间O(1)
     * @return
     */
    @Override
    public void set(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index 输入错误");
        }
        data[index] = element;
    }

    /**
     * 时间O(n)
     * @return
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index 输入错误");
        }

        E res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];

        }
        size--;

        //Lazy操作，缩小到1/4再操作, 1/4 = 0
        if(data.length / 4 == size && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return res;
    }

    /**
     * 时间O(n)
     * @return
     */
    @Override
    public boolean remove(E elemnent) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if(data[i] == elemnent) {
                index = i;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("元素不存在");
        }
        remove(index);
        return true;
    }

    @Override
    public void print() {
        System.out.println("Size : " + size);
        System.out.println("capacity : " + data.length);
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");

        }
    }

    /**
     * 时间O(n)
     * @return
     */
    @Override
    public void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

}
