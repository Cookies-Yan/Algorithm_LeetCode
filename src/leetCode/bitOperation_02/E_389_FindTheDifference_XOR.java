package leetCode.bitOperation_02;

/**
 * Time O(n)
 * Space O(1)
 *
 *  同样的字母出现了两遍， 异或以后还等于之前的数字
 * 4 : 0100
 * 6 : 0110
 *     0010
 * 4 : 0100
 *     0110 -> 6
 */
public class E_389_FindTheDifference_XOR {

    public char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1); //先把t最后多出来的字母拿到
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i); // ^=异或
            c ^= t.charAt(i);
        }
        return c;
    }
}
