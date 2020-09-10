package algorithm.myList.linkedList;

public interface ILinkedList<E> {

    /**
     * 占用大小
     * @return
     */
    int size();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 按index插入
     * @param data
     * @param index
     */
    void add(int index, E data);

    /**
     * 正常插入
     * @param data
     * @return
     */
    boolean add(E data);
    /**
     * 头部插入
     * @param data
     */
    void addFirst(E data);

    /**
     * 尾部插入
     * @param data
     */
    void addLast(E data);

    /**
     * 头部删除
     * @return
     */
    E removeFirst();

    /**
     * 尾部删除
     * @return
     */
    E removeLast();

    /**
     * 删除指定元素
     * @param data
     * @return
     */
    boolean remove(E data);

    /**
     * 按index删除
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 拿到指定元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * get第一个元素
     * @return
     */
    E getFirst();

    /**
     * get最后一个元素
     * @return
     */
    E getLast();
    /**
     * 更改指定元素
     * @param index
     * @param data
     */
    void set(int index, E data);

    /**
     * 查看是否包含此元素
     * @param data
     * @return
     */
    boolean contains(E data);
    /**
     * 打印
     */
    void print();

}
