package leetCode.math_03;

/**
 * time O(n)
 * Space O(n)
 * 真正的时间复杂度比O（n）小
 */
public class E_504_Base7 {
    public static String convertToBase(int num) {
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        Boolean negative = false;

        if (num < 0) {
            negative = true;
        }
        while (num != 0) {
            sb.append(Math.abs(num % 7));
            num = num / 7;
        }

        if (negative) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    /**
     * 递归
     * @param num
     * @return
     */
    public static String convertToBase7_2(int num) {
        if (num < 0) {
            return "-" + convertToBase7_2(-num);
        }
        if (num < 7) {
            return num + ""; //num进行了字符串的转换
        }
        return convertToBase7_2(num / 7) + num % 7;
    }

    public static void main(String[] args) {
        System.out.println(convertToBase(100));
    }

    /**
     * 正向解法（慢）
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        int reminder = num % 7;
        int divisor = num / 7;
        int temp = 0;
        int level = 0;
        while(reminder != 0 || divisor != 0){
            temp = temp + reminder * (int)Math.pow(10, level);
            reminder = divisor % 7;
            divisor = divisor / 7;
            level ++;

        }
        return temp + "";
    }
}
