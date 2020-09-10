package leetCode.string_09;

public class E_058_LengthOfLastWord {
    public int lengthOfLastWord(String s) {

        String[] str = s.split(" ");;
        if (str.length == 0) return 0;
        return str[str.length - 1].length();

    }
}
