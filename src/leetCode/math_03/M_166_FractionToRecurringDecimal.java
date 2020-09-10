package leetCode.math_03;

import java.util.HashMap;

/**
 * Time O(n)
 * Space O(n) 用到stringbuilder
 *
 * 1. 0 + - 越界
 * 2. 整数
 * 3. 小数 -> 循环
 */
public class M_166_FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        res.append(((numerator > 0) ^ (denominator > 0) ? "-" : "")); //异或, 同号正值，异号负值
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        //小数
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>(); //long是数值， Integer是位置
        map.put(num, res.length());

        while (num != 0) {
            num *= 10; // 2/3 为例
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")"); //在所有的数的最后加右括号
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}
