package leetCode.math_03;

/**
 * 考虑情况： + - not valid 越界 " "
 * Time O(n)
 * Space O(1)
 */
public class E_008_StringToInteger {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim(); //去掉前后空格
        if (str.equals("")) return 0;
        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        long res = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE)  return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * res < Integer.MIN_VALUE)  return Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }
}
