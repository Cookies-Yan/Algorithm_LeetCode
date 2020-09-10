package leetCode.string_09;

public class E_125_ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++; //排除一些标点符号
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--; //排除一些标点符号
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
