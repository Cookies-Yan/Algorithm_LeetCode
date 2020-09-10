package leetCode.array_04;

import java.util.HashSet;

public class E_409_LongestPalindrome {

    /**
     * Time O(n)
     * Space O(1)
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                count++;
            } else {
                set.add(c);
            }
        }
        if (set.size() != 0) return count * 2 + 1;
        return count * 2;
    }

    /**
     * Time O(n)
     * Space O(1)
     * @param s
     * @return
     */
    public int longestPalindrome1(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] count = new char[256];
        int res = 0;
        boolean bool = false;
        for (char c : s.toCharArray()) {
            if (count[c] > 0) {
                count[c]--;
                res++;
            } else {
                count[c]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) bool = true;
        }
        if (bool) return res * 2 + 1;
        return res * 2;
    }
}
