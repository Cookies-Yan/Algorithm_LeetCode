package leetCode.string_09;

public class M_161_OneEditDistance {

    /**
     * 三种情况
     * s.length()  = t.length()
     * s.length()  > t.length()
     * s.length()  < t.length()
     * 已经在末未处理 "abvd ,abvd" 以及 "abc, abcdef"的情况，是否insert一位可以达成
     * @param s
     * @param t
     * @return
     */
    public boolean isOneEditDistance(String s, String t) {

        for(int i = 0; i < Math.min(s.length(), t.length()); i++) {

            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1, s.length()).equals(t.substring(i + 1, t.length()));
                } else if (s.length() < t.length()) {
                    return s.substring(i, s.length()).equals(t.substring(i + 1, t.length()));
                } else {
                    return s.substring(i + 1, s.length()).equals(t.substring(i, t.length()));
                }
            }

        }
        return Math.abs(s.length() - t.length()) == 1;
    }

}
