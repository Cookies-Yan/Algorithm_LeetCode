package leetCode.dynamic_18;

public class H_097_InterleavingString {
    /**
     * Time O(n * m)
     * Space O(n * m)
     * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * Output: true
     *
     * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
     * Output: false
     * 不太懂
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (dp[i - 1][j] && s2.charAt(i - 1) == s3.charAt(i + j -1))
                        || (dp[i][j - 1] && s1.charAt(j - 1) == s3.charAt(i + j -1));
            }
        }
        return dp[s2.length()][s1.length()];
    }

    /**
     * 暴力破解
     */
    public boolean isInterleave1(String s1, String s2, String s3) {
        // 题目没有明确说明s123是否为null，需要判null，这里直接令其等于空字符
        // 若s1为空，即不会参数空指针异常也不会参与到计算当中
        if(s1 == null) s1 = "";
        if(s2 == null) s2 = "";
        if(s3 == null) s3 = "";
        return helper(s1, s2, s3, 0, 0, 0);
    }

    public boolean helper(String s1, String s2, String s3, int i, int j, int k){
        // 若回溯用完了s1,s2,s3，说明能够s3能够被交替组成
        if(i == s1.length() && j == s2.length() && k == s3.length())
            return true;

        if(k >= s3.length())
            return false;

        if(i < s1.length()){
            // 若当前s1的i位置的字符与s3的k位置字符相等，则消耗一个字符，
            // 并向下回溯，若回溯返回true则返回的这个true最开始一定
            // 是由该函数内第二行代码返回的，即表示s3能够被交替组成，直接返回true
            if(s1.charAt(i) == s3.charAt(k) &&
                    helper(s1, s2, s3, i+1, j, k+1))
                return true;
        }

        if(j < s2.length()){
            if(s2.charAt(j) == s3.charAt(k) &&
                    helper(s1, s2, s3, i, j+1, k+1))
                return true;
        }

        // 在此i、j、k下，无论如何都不能组成s3.substring(0, k+1),返回false
        return false;
    }

    public static void main(String[] args) {
        H_097_InterleavingString a = new H_097_InterleavingString();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        System.out.println(a.isInterleave1(s1, s2, s3));
    }

}
