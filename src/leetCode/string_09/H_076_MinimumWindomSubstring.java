package leetCode.string_09;

public class H_076_MinimumWindomSubstring {
    /**
     * Time O(n)
     * i,j一共走了两遍 2n
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {

        int[] count = new int[256]; //没说大小写 就写256 安全一点
        for (char c : t.toCharArray()) {
            count[c]++; //自动将c 转化为数字
        }

        int len = t.length();
        int min = Integer.MAX_VALUE;
        int from = 0;
        for (int i = 0, j = 0; i < s.length(); i++) { //两个指针
            if (count[s.charAt(i)]-- > 0) { //即便进不了if还是会--，控制count里面字母
                len--;
            }
            while (len == 0) {      //控制t中字母
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++count[s.charAt(j++)] > 0) { //控制count里面字母
                    len++;
                }
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }
}
