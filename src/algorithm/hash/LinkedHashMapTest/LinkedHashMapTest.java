package algorithm.hash.LinkedHashMapTest;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

    public static void main(String[] args) {

//如果accessOrder是False，我们所有的entry按照插入的顺序进行排序，如果是true，我们要按照LRU的顺序进行排序
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put("1","1");
        linkedHashMap.put("2","1");
        linkedHashMap.put("3","1");
        linkedHashMap.put("4","1");
        linkedHashMap.put("5","1");
        print(linkedHashMap);
        linkedHashMap.get("1");
        print(linkedHashMap);
    }

    public static void print(LinkedHashMap<String, String> linkedHashMap) {

        for(Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + "\t");
        }
        System.out.println();
    }




}
