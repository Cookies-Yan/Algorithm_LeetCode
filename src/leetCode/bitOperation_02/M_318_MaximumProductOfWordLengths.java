package leetCode.bitOperation_02;

public class M_318_MaximumProductOfWordLengths {
    /**
     * BitMap
     * Time : O(n^2)
     * Space : O(n)
     *
     * val |= 1 << (words[i].charAt(j) - 'a');
     *     |=
     *     +=
     * val = val | ...
     *
     * 1 << 0 0001 = 1  a
     * 1 << 1 0010 = 2  b
     * 1 << 2 0100 = 4  c
     * 1 << 3 1000 = 8
     *
     * abc = 00111 = 7  ab = 00011 = 3
     *
     * (bytes[i] & bytes[j]) == 0
     *
     * abc & ab : 00111
     *            00011
     *            00011 != 0 说明有重复
     * 有一点重复就不行 ["abc","agf"] 结果是0
     * 不用担心越界，因为字母只有26个,但是一般是32bit
     *
     */
    public static int maxProduct(String[] words) {
        int res = 0;
        int[] bytes = new int[words.length];
//        for (int i = 0; i < words.length; i++) {
//            System.out.println(bytes[i]);
//        }
        for (int i = 0; i < words.length; i++) {
            int val = 0;
            for (int j = 0; j < words[i].length(); j++) {
                val |= 1 << (words[i].charAt(j) - 'a');
            }
            bytes[i] = val;
        }

        for (int i = 0; i < bytes.length; i++) {
            for (int j = i + 1; j < bytes.length; j++) {
                if ((bytes[i] & bytes[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    /**
     * 暴力破解,很慢
     */
    public boolean noCommonLetters1(String s1, String s2) {
        for (char ch : s1.toCharArray()) {
            if (s2.indexOf(ch) != -1) return false;
        }
        return true;
    }

    public int maxProduct1(String[] words) {
        int n = words.length;
        int maxProd = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (noCommonLetters1(words[i], words[j])) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(words));
    }
}
