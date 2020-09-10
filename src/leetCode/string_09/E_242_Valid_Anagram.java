package leetCode.string_09;

import java.util.HashMap;

/**
 * Created by Cookies
 * Time: O(n)
 * Space: O(1)
 */
//countSort
public class E_242_Valid_Anagram {
    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int num: count){
            if(num != 0){
                return false;
            }
        }
        return true;
    }
//HashMap
    public static boolean isAnagram1(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else{
                map.put(c,1);
            }
        }
        for(char c : t.toCharArray()){
            if(map.containsKey(c)){
                if(map.get(c) == 1){
                    map.remove(c);
                }else{
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
        System.out.println(isAnagram1(s,t));
    }
}
