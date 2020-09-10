package leetCode.array_04;

public class H_087_ScrambleString {
    /**
     * Time O(n!)
     * Space O(n)
     * 这个题不需要用DP
     */
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;

        int[] letters = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }

        for (int num : letters) {
            if (num != 0) {
                return false;
            }
        }
        for (int i = 1; i < len; i++) {
            /**
             * [0, 1)
             * 正着拆 (gr 和 te && eat 和 arg) 即为如果叶子节点都相等的话,就肯定是一个Scramble string
             * great
             * tearg
             */
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) return true;
            /**
             * 反着拆(0-2 和 3-5即为gr和rg) && eat 和 tea
             * 01 234
             * gr eat
             * tea rg
             */
            if (isScramble(s1.substring(0, i), s2.substring(len - i))
                    && isScramble(s1.substring(i), s2.substring(0, len - i))) return true;
        }
        return false;
    }
}
