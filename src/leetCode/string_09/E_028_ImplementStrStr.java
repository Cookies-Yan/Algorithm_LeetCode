package leetCode.string_09;

public class E_028_ImplementStrStr {

    /**
     Created by Cookies

     time:O(n^2)
     space:O(1)
     **/
    public static int strStr(String haystack, String needle){

        if(needle.length() == 0) return 0;
        for(int i = 0; i <= haystack.length() - needle.length(); i++){

            if(haystack.substring(i, i + needle.length()).equals(needle)) return i;

        }
        return -1;

    }

    public int strStr2(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) {
                break;
            }
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "goodbye";
        String needle = "oo";
        int res = strStr(haystack, needle);
        System.out.println(res);
    }

}


/**
 substring()在Java 7 之前是常数复杂度，现在为线性复杂度。
 **/
