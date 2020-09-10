package leetCode.string_09;

public class E_009_PalindromeNumber {

    public boolean isPalindrome(int x) {

        if(x < 0 || x != 0 && x % 10 == 0) return false; //1000
        int rev = 0;
        int palind = x;

        while (x > 0){

            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return palind == rev;
    }
}
