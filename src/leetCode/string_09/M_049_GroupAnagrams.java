package leetCode.string_09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class M_049_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();


        for (int i = 0; i < strs.length; i++) {

            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch); //返回值是void，不能赋值。
            String s = String.valueOf(ch);

            if (!map.containsKey(s)) {
                List<String> list = new ArrayList<>();
                map.put(s, list);
                list.add(strs[i]);
            } else {
                map.get(s).add(strs[i]);
            }
        }

        return new ArrayList<>(map.values());
    }

}
