package leetCode.string_09;

public class E_171_ExcelSheetColumnNumber {

    public int titleToNumber(String s) {

        if (s == null || s ==  "") return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }

}
