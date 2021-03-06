package leetCode.string_09;

import java.util.HashMap;

/**
 * 有对应关系的都用hashMap
 */
public class E_246_StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            if (!map.containsKey(num.charAt(left))) {
                return false;
            }
            if (map.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}
