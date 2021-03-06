package algorithm.stack;

public interface IArrayStack<E> {

    /**
     * 容量大小
     * @return
     */
    int capacity();

    /**
     * 实际占用大小
     * @return
     */
    int size();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 插入数据，入栈
     * @param e
     */
    void push(E e);

    /**
     * 查看栈顶
     * @return
     */
    E peek();

    /**
     * 删除元素，出栈
     * @return
     */
    E pop();

    /**
     * 打印数据和结果
     */
    void print();

    /**
     * 改变capacity大小
     * @param capacity
     */
    void resize(int capacity);
}
