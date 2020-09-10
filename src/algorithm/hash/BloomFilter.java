package algorithm.hash;

import java.util.BitSet;

/**
 *
 */
public class BloomFilter {

    /**
     * <<  : 左移运算符，num << 1,相当于num乘以2
     * >>  : 右移运算符，num >> 1,相当于num除以2
     * 1 << 25 相当于2^25 = 33554432
     */
    // DEAFULT_SIZE就是开始的capacity
    private static final int DEAFULT_SIZE = 1 << 25;

        private BitSet bits = new BitSet(DEAFULT_SIZE);
        //6个hash function进行初始化
        private static final int[] seeds = new int[]{5, 7, 11, 13, 37, 61};

        private HashFunction[] functions = new HashFunction[seeds.length];

        private static class HashFunction {
            private int capacity;
            private int seed;

            public HashFunction(int capacity, int seed) {
                this.capacity = capacity;
                this.seed = seed;
            }

            public int hash(String value) {
                int res = 0;
                for (int i = 0; i < value.length(); i++) {
                    res = seed * res + value.charAt(i);
                }
                return (capacity - 1) & res;
            }

        }

    public BloomFilter() {
            for(int i = 0; i < seeds.length; i++) {
                functions[i] = new HashFunction(DEAFULT_SIZE, seeds[i]);
            }

    }

    public void add(String value) {
            for (HashFunction function : functions) {
                bits.set(function.hash(value), true);
            }
    }

    public boolean constains(String value) {
            if(value == null) {
                return false;
            }
            boolean res = true;
            for(HashFunction function : functions) {
                res = res && bits.get(function.hash(value));
            }
            return res;
    }

    public static void main(String[] args) {
//        System.out.println(DEAFULT_SIZE == Math.pow(2,25));
        String value = "cspiration";
        BloomFilter filter = new BloomFilter();
        System.out.println(filter.constains(value));
        filter.add(value);
        System.out.println(filter.constains(value));
    }

}
