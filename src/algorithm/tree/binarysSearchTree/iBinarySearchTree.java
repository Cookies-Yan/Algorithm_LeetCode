package algorithm.tree.binarysSearchTree;

//树在面试的时候，一般不写泛型
public interface iBinarySearchTree {

    void add(int val);

    void remove(int val);

    boolean contains(int val);

    int size();

    boolean isEmpty();
}
