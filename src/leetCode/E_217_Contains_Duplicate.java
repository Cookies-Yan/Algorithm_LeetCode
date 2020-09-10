package leetCode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Cookies
 */

public class E_217_Contains_Duplicate {
// HashMap
    public static boolean containsDuplicate(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                return true;
            }else{
// 在此写1，5，1000都没有任何关系。因为我们只想判断有还是无，因此用计数有点麻烦。
                map.put(num, 1);
            }
        }
        return false;
    }
//    HashSet
    public static boolean containsDuplicate1(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
//    当add成功是，即没有重复obcject, 返回true. Or false.
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(containsDuplicate(nums));
        System.out.println(containsDuplicate1(nums));
    }
}
