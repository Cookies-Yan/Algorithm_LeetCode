package leetCode.array_04;

public class E_243_ShortestWordDistance {
    /**
     * 暴力解法 O(n^2)
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance(String[] words, String word1, String word2) {

        int res = words.length;
        int a = -1;
        int b = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
            } else if (words[i].equals(word2)) {
                b = i;
            }
            if (a != -1 && b != -1) {
                res = Math.min(res, Math.abs(a - b));
            }
        }
        return res;
    }

    /**
     * 优化 O(n)
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance1(String[] words, String word1, String word2) {
        int res = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2)) {
                        res = Math.min(res, Math.abs(i - j));
                    }
                }
            }
        }
        return res;
    }

}
