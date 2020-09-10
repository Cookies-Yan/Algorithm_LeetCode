package quickSolution.bitOperation_01;

public class BaseType {

    public static void baseType() {
        /** int 和 integer初始化的值不一样，integer是一个类，int没有null */
        int a = 0;
        int b = 0;
        Integer c = null;
        System.out.println(a == b);

        /** integer不用new对象直接赋值 */
        Integer x = 3;
        Integer y = 3;
        System.out.println(x == y);
        /**在java源码中，cache第一次调用初始化位-128~127, 所以用'=='的话 需要在这个范围去比较
         * 如果超过的话，我们需要用equals()去进行对象比较
         */
        Integer j = 130;
        Integer k = 130;
        System.out.println(j == k);
        System.out.println(j.equals(k));

        /**
         * 类型转换
         */
        String s = "123";
        String ss = x.toString();
        System.out.println(Integer.parseInt(s));
    }

    public static void main(String[] args) {
        baseType();
    }
}
