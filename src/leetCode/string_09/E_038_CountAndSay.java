package leetCode.string_09;

public class E_038_CountAndSay {

    public static String countAndSay(int n) {

        int i = 1;
        String res = "1";
        while(i < n){
            int count = 0;
            StringBuilder sb = new StringBuilder();
            char c = res.charAt(0);
            for(int j = 0; j <= res.length(); j++){
                if(j != res.length() && res.charAt(j) == c){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(c);
                    if(j != res.length()){
                        count = 1;
                        c = res.charAt(j);
                    }
                }
            }
            res = sb.toString();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        String res = countAndSay(5);
        System.out.println(res);
    }
}

/***
 * Stringbuilder
 * 当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。
 * 和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
 * StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。
 * 由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。
 *
 *
 * public StringBuffer append(String s)
 * 将指定的字符串追加到此字符序列。
 *
 * public StringBuffer reverse()
 * 将此字符序列用其反转形式取代。
 *
 * public delete(int start, int end)
 * 移除此序列的子字符串中的字符。
 *
 * charAt()
 * charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1
 * public char charAt(int index)
 *
 */

