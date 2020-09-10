package algorithm.unionFind.impl;

import algorithm.unionFind.IUnionFind;

/**
 * LC323
 * 对于QuickFind方法来说并不算效率非常高的一种方法
 */
public class QuickFindImpl implements IUnionFind {

    /**
     * 节点个数
     */
    int count;

    /**
     * 节点
     */
    private int[] id;

    public QuickFindImpl(int count) {

        this.count = count;
        id = new int[count];

        /**
         * index: 0, 1, 2, 3, 4, 5
         * value: 0, 1, 2, 3, 4, 5
         */
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            
        }
    }

    @Override
    public int count() {
        return count;
    }

    /**
     * Union(0,1)(1,2)(2,3)
     *        A  B
     * index: 0, 1, 2, 3, 4, 5
     * value: 0, 1, 2, 3, 4, 5  ->  1, 1, 2, 3, 4, 5  ->   2, 2, 2, 3, 4, 5  ->  3, 3, 3, 3, 4, 5
     */
    //Time: O(n)
    @Override
    public void union(int x, int y) {
        int A = find(x); //集合A
        int B = find(y); //集合B
        if(A == B) {
            return;
        }
        //将所有与A一个集合的节点都union到B上
        for(int i = 0; i < id.length; i++) {
            if(id[i] == A) {
                id[i] = B;
            }
        }
    }

    //Time: O(1)
    @Override
    public int find(int index) {
        if(index < 0 || index >= count) {
            throw new IllegalArgumentException("越界");
        }
        return id[index];

    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
