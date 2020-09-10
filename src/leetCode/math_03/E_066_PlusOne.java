package leetCode.math_03;

import java.util.Arrays;
/**
 * Created by cookies
 * Time: O(n)
 * Space: O(n)
 *
 * Case1 : 1011 1012
 * Case2 : 1099 1100
 * Case3 : 9999 10000
 *
 */


public class E_066_PlusOne {
    public static int[] plusOne(int[] digits){
        if(digits == null || digits.length == 0) return digits;
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9){
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] newArray = new int[digits.length + 1];
        newArray[0] = 1;
        return newArray;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,9,9,9,9,9};
        System.out.println(Arrays.toString(plusOne(nums)));
    }
}
