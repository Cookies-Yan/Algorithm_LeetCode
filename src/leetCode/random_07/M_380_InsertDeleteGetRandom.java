package leetCode.random_07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class M_380_InsertDeleteGetRandom {

    /**
     * random.nextInt(10) 输出的是0-9
     */
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    Random rmd;

    /** Initialize your data structure here. */
    public M_380_InsertDeleteGetRandom() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.rmd = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    /**
     * 把最后一个元素删除，并且拿到值，用hashmap拿到index.
     * 如果需要删除的元素不在最后一个，那么用最后一个值替换需要删除的值（达到等同删除的目的）
     */
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.remove(val);
        int lastVal = list.remove(list.size() - 1);
        if (index != list.size()) {
            list.set(index, lastVal);
            map.put(lastVal, index);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rmd.nextInt(list.size()));
    }
}
