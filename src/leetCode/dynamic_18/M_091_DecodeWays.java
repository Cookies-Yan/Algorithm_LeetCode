package leetCode.dynamic_18;

public class M_091_DecodeWays {

    /**
     *  Time: O(n)
     *  算到最后一步 i = 4 因为要算的最后一个数为i - 1
     *  当算到最后一步如同时进行 dp[i] += dp[i - 1]
     *                       dp[i] += dp[i - 2]
     *  的原因是，我们确定了最后一个数本身6，可以与前面已求得的前3个数字组合进行组合：
     *  "2， 2， 2"|    +              | "2， 2， 2， 6"
     *  "2， 22"   |  ===> "6"  ===>   | "2， 22， 6"       =====> 3种
     *  "22，2 "   |                   | "22，2， 6"
     *  加上我们确定6和6前的数字2，组合可以与前2个数字组合进行组合：
     *  "2， 2"|    +            | "2， 2， 26"
     *  "22"   |  ===> "6"  ===> | "2， 26"          =====>2种
     *
     *  3 + 2 = 5种
     *
     * @param s
     * @return
     */
    public static int numDecodings(String s) {

        if (s == null || s.length() == 0) return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; //一个base case
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "2226";
        System.out.println(numDecodings(s));
    }
}
