package algorithm.unionFind.impl;

import algorithm.unionFind.IUnionFind;

/**
 * 对quickFind进行时间复杂度的优化
 * 将Union的时间复杂度从O(n) -> O(h)
 * 牺牲find的时间复杂度，来优化union时间复杂度
 */
public class QuickByRankImpl implements IUnionFind {

    /**
     * 节点个数
     */
    int count;

    /**
     * 节点
     */
    private int[] parents;

    /**
     * 高度
     */
    private int[] rank;

    public QuickByRankImpl(int count) {

        this.count = count;
        parents = new int[count];
        this.rank = new int[count];

        /**
         * index: 0, 1, 2, 3, 4, 5
         * value: 0, 1, 2, 3, 4, 5
         */
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int count() {
        return count;
    }

    //Time: O(h)
    @Override
    public void union(int x, int y) {
        int xRoot = find(x); //集合A
        int yRoot = find(y); //集合B
        if(xRoot == yRoot) {
            return;
        }
        //小的union到大的上面
        //发生变化
        if(rank[xRoot] < rank[yRoot]){
            //小高度union到大高度上，总高度不变
            parents[xRoot] = yRoot;
        } else if(rank[yRoot] < rank[xRoot]){
            //小高度union到大高度上，总高度不变
            parents[yRoot] = xRoot;
        } else {
            //高度相等,高度要加1
            parents[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    //Time: O(1)
    //找根节点,类似于索引堆
    @Override
    public int find(int index) {
        if(index < 0 || index >= count) {
            throw new IllegalArgumentException("越界");
        }
        while(index != parents[index]) {
            index = parents[index];
        }
        return index;

    }

    @Override
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
