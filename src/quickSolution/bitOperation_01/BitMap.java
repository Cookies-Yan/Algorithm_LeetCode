package quickSolution.bitOperation_01;

import java.util.BitSet;

public class BitMap {

    /**
     * 位运算 BitMap应用例题
     * @param str
     * @return
     */
    public static boolean isUniqueChars(String str) {
        //一般扩展ASCII 有256个字符
        if (str.length() > 256) return false;
        
        int checker = 0;

        /**
         * a，97 % 32 = 1 ---- 1
         *
         * b，98 % 32 = 2 ---- 1 << (2-1) = 2
         *
         * c，99 % 32 = 3 ---- 1 << (3-1) = 4
         */
        for (int i = 0; i < str.length(); i++) {
             int val = str.charAt(i);
             if ((checker & (1 << val)) > 0) {
                return false;
             }
             checker |= (1 << val);
             System.out.println(Integer.toBinaryString(checker));
        }
        return true;
    }


    public static void bitSet() {
        /**
         * 超过2^6会进行扩容 2^6 +  2^6 + ......
         */
        BitSet bitSet = new BitSet();
        System.out.println(bitSet.get(0));
        System.out.println(bitSet.size());

        bitSet.set(0);
        System.out.println(bitSet.get(0));
        System.out.println(bitSet.size());

        bitSet.set(65);
        System.out.println(bitSet.get(65));
        System.out.println(bitSet.size());

        bitSet.set(129);
        System.out.println(bitSet.get(65));
        System.out.println(bitSet.size());
    }

    public static void main(String[] args) {
//          bitSet();
        /**
         * 32位一循环，所以不能超过32，否则就会位重复：
         *      //位移运算符的右操作数要完成模32的运算，如下两个操作值相等
         *      System.out.println(1 << 35);//8
         *      System.out.println(1 << 3);//8
         *      //如果左操作数是long类型，那么右操作数会完成模64的运算
         *      System.out.println(1L << 67);//8
         *      System.out.println(1L << 3);//8
         */
        System.out.println(isUniqueChars("abcitjgkhom.!")); //在这里如果超越字母(即超过26个跨度)就会变成false
        int checker= 0 ;
        checker |= (1 << 97);
        System.out.println(Integer.toBinaryString(checker));
        int test = 0;
        test <<= 1;
        System.out.println(Integer.toBinaryString(test));
    }
}
