package algorithm.stack;

public interface ILinkedListStack<E> {

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

}
