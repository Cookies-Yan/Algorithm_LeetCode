package algorithm.myList;

public interface IMyList<E> {

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
     * 加入：末尾
     */
    boolean add(E element);

    /**
     * 加入中间插入
     */
    void add(int index, E element);

    /**
     * 查找元素
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * 找到元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 修改元素
     * @param index
     * @param element
     */
    void set(int index, E element);

    /**
     * 根据index查找删除
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 找到元素进行删除
     * @param elemnent
     * @return
     */
    boolean remove(E elemnent);

    /**
     * 打印数据和结果
     */
    void print();

}
