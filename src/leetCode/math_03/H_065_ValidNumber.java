package leetCode.math_03;

/**
 * 如果面经有 就准备 没有就不准备
 * Some example:
 * "0"  => true
 * " 0.1" => true
 * "abc"  => false
 * "1 a"  => false
 * "2e10" => false
 *
 * Time O(n)
 * Space O(1)
 */
public class H_065_ValidNumber {

    public boolean isNumber(String s) {
        s = s.trim();
        boolean numberSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
                numberAfterE = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen && numberAfterE;
    }
}
