package leetCode.math_03;

/**
 * index 1                 1  2  3      index i
 * index 2                    4  5      index j
 *                   -----------------
 *                            1  5
 *                         1  0
 *                      0  5
 *                   -----------------
 *                         1  2
 * indices[1,2]         0  8            index[i+j, i+j+1] 即为单个相乘结果的index位置
 *                   0  4
 *            index [0, 1, 2, 3, 4]
 *                     [p1, p2]
 * 最多有num1 + num2 位
 */
public class M_043_MultiplyStrings {
    //Time O(m * n)
    //Space O(m + n)
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return "0";
        int[] digits = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = product + digits[p2]; //sum是个P2的值
                digits[p1] += sum / 10;
                digits[p2] = sum % 10;
            }
        }
        //将所有乘积都填入digits中后再转化成String
        StringBuilder res = new StringBuilder();
        //处理这两种情况 digits = [0,0,1,2,3] 或者[0,0,1,0,2]
        for (int digit : digits) {
            if (!(digit == 0 && res.length() == 0)) {
                res.append(digit);
            }
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
