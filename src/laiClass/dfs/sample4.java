package laiClass.dfs;

/**
 * Given a string with no duplicated letters, how to print out all permutations of the string
 * E.g:
 *      a b c
 * Output:
 *      [abc] [acb] [bac] [bca] [cab] [cba]
 */
public class sample4 {

    /**
     * Solution 1
     *                 root = "abc"
     *              /        |       \
     * level 0    a(bc)     b(ac)    c(ab)
     *            /   \     /   \    /    \
     * level 1  b(c) c(b) a(c) c(a) a(b)  b(a)
     *           |    |    |     |   |     |
     * level 2   c    b    c     a   b     a
     *
     * @param input
     * @param answer
     * @param used
     * @param level
     */
    public void permutation(String input, String answer, boolean[] used, int level) {

        if (level == input.length()) {
            System.out.print("[" + answer + "]" + " ");
            return;
        }

        for (int i = 0; i < input.length(); i++) {

            if (!used[i]) {
                answer += input.charAt(i);
                used[i] = true;
            } else {
                continue;
            }
            permutation(input, answer, used,level + 1);
            used[i] = false;
            answer = answer.substring(0, level);

        }
    }

    /**
     * Solution 1.1
     * @param input
     * @param answer
     * @param used
     * @param level
     */
    public void permutation2(String input, String answer, boolean[] used, int level) {

        if (level == input.length()) {
            System.out.print("[" + answer + "]" + " ");
            return;
        }

        for (int i = 0; i < input.length(); i++) {

            if (!used[i]) {
                answer += input.charAt(i);
                used[i] = true;
                permutation(input, answer, used, level + 1);
                used[i] = false;
                answer = "";
            }

        }
    }

    /**
     * Solution 2
     * Swap - Swap
     */
    public void permutation1(String input, int index) {

        if (index == input.length()) {
            System.out.print("[" + input + "]" + " ");
            return;
        }

        for (int i = index; i < input.length(); i++) {
            input = swap(input, index, i);
            permutation1(input, index + 1);
            input = swap(input, index, i);
        }
    }

    public String swap(String input, int start, int end) {
        char[] temp = input.toCharArray();
        char t = temp[start];
        temp[start] = temp[end];
        temp[end] = t;
        return new String(temp);
    }

    public static void main(String[] args) {
        sample4 a = new sample4();
        boolean[] used = new boolean[3];
        String answer = "";
//        a.permutation1("abc", 0);
        System.out.println();
        a.permutation2("abc", answer, used, 0);
    }
}
