package leetCode.backTracking_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 使用backtracking
 */
public class M_017_LetterCombinationsOfAPhoneNumber {

    /**
     *  java 双括号: https://www.hollischuang.com/archives/533
     *  第一层括弧 实际是定义了一个内部匿名类 （Anonymous Inner Class），
     *  第二层括弧 实际上是一个实例初始化块 （instance initializer block），这个块在内部匿名类构造时被执行。
     *  实例初始化块中可以使用其容器范围内的所有方法及变量
     *  但特别需要注意的是实例初始化块是在构造器之前运行的。
     */
    static HashMap<String, String> phone = new HashMap<String, String>()
    {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    static List<String> res = new ArrayList<String>();
    public  static void backtrack(String combination, String next_digits) {

        if(next_digits.length() == 0) {
            res.add(combination);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for(int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(letter + combination, next_digits.substring(1));
            }
        }
    }

    public static List<String> letterCombinations(String digits) {

        if(digits.length() != 0) {
            backtrack("", digits);
        }
        return res;
    }

    /**
     * 方法2
     * @param args
     */
    private String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(res, "", digits, 0);
        return res;
    }

    /**
     * index是需要的，因为我们要定位例如23每个数字的位置
     * @param res
     * @param s
     * @param digits
     */
    public void helper(List<String> res, String s, String digits, int index) {
        if (s.length() == digits.length()) {
            res.add(s);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {

            //参数里面不能是i + 1
            helper(res, s + letters.charAt(i), digits, index + 1);

        }
    }


    public static void main(String[] args) {

        System.out.println(letterCombinations("23"));

    }
}
