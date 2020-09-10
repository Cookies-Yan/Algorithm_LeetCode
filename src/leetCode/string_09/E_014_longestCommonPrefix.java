package leetCode.string_09;

/**
 Created by Cookies
 Time O(n^2)
 **/
// case:"edwardshi", "edward","edwar","edwardshidd"
// time: O(n*l)
// spac: O(1)

public class E_014_longestCommonPrefix {

    public static String longestCommonPrefix_14(String[] strs){
        if(strs == null || strs.length == 0) return " ";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(res) != 0){
                res = res.substring(0,res.length() - 1);
            }
//            int j = strs[i].indexOf(res);
//            System.out.println(j);
        }

        return res;
    }

    /**
     * 虽然有substring() 但是只在return的时候返回，所以是不用管其时间复杂度
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
    public static void main(String[] args){
        String[] strs =new String[]{"edwardshi", "edward","edwar","edwardshidd"};
        String[] strs1 = new String[]{"edwardshi", "ar","edwar","edwardshidd"};
        String r = longestCommonPrefix_14(strs1);
        System.out.println('"'+r+'"');
    }

}

/**
 indexOf(int ch): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 indexOf(int ch, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 indexOf(String str): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 indexOf(String str, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 **/
/**
 public String substring(int beginIndex)返回字符串
 public String substring(int beginIndex, int endIndex)返回字符串 左闭合右开区间，
 **/
