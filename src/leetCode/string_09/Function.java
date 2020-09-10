package leetCode.string_09;

import java.util.HashMap;

public class Function {
    public static void function() {
        /**
         * 在String中已经定义好了，本质是char类型的字符串的数组，所以不用<>
         * .length在数组中不是一个方法
         * .length() 是string中的一个方法。
         */
        String s1 = "abc";
        String s2 = "abc"; //不用new 自己new
        HashMap<Integer, Integer> map = new HashMap<>();
        /**
         * java中的"=="比较的地址/引用/内存的地址
         * 很多情况都用equals,可能程序是对的，但是逻辑是错的
         */
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2); //s1 和 s2本质是同一块地址

        /**
         * substring()
         * [)左闭右开
         */
        String s = "banana";
        System.out.println(s.substring(1));
        System.out.println(s.substring(1, 3));
        /**
         * indexOf("s")
         * 从头到尾是否包含s, 返回头index
         * lastIndexOf("s")
         * 从尾部到头是否包含s，返回尾index
         *
         */
        System.out.println(s.indexOf("na"));
        System.out.println(s.indexOf("x"));
        System.out.println(s.lastIndexOf("an"));
        /**
         *startWith("s")
         * 判断string是否以s开头
         */
        System.out.println(s.startsWith("ba"));
        /**
         * toCharArray()
         * 把string变成char类型的数组
         */
        char[] chars = s.toCharArray();
        for(char ch : chars) {

        }
        for (int i = 0; i < s.length(); i++) {
            s.charAt(i);
        }
        /**
         * split()
         */
        String[] strings = s.split("n");
        for (String ss : strings) {
            System.out.println(ss);
        }
        /**
         * trim()
         * 对头空格进行处理
         */
        String sss = "   banana";
        System.out.println(sss);
        System.out.println(sss.trim());

        /**
         * Character
         */
        char c = '9';
        System.out.println(Character.isDigit(c));
        char c2 = 'a';
        System.out.println(Character.isLetter(c));
        System.out.println(Character.isLetterOrDigit(c));
        /**
         * 类型转换
         */
        int num = 11;
        String s3 = String.valueOf(num);
        System.out.println(String.valueOf(num));
        System.out.println(Integer.parseInt(s3)); //转int型
        /**
         * substring time O(n)
         */
        /**
         * 正则表达式
         */
        String z = "a//b//c";
        System.out.println(z);
        String[] split = z.split("/+");
        for (String q : split) {
            System.out.println(q);
        }

    }

    /**
     * string 不是8大基本类型，而是对象
     * 跟HashMap一个级别的。
     * @param args
     */
    public static void main(String[] args) {
        function();
    }

}
