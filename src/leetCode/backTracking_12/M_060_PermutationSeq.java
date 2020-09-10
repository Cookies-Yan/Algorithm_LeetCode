package leetCode.backTracking_12;

import java.util.ArrayList;
import java.util.List;

public class M_060_PermutationSeq {

    public static String getPermutation(int n, int k) {

        List<Integer> res = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            res.add(i);
        }

        //当n等于多少的时候他的全排列, fact = factorial
        int[] fact = new int[n];
        fact[0] = 1; // 0的时候相当于没有
        for(int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
        }

        k -= 1; //因为index从零开始，所以要事先减1
        for(int i = 1; i <= n; i++) {

            int index = k / fact[n - i];
            sb.append(String.valueOf(res.get(index))); //String.value将括号内的值转换成string type
            res.remove(index);
            k -= index * fact[n - i];
        }

        return String.valueOf(sb);
    }

    public static void main(String[] args) {

        System.out.println(getPermutation(3,3));
    }
}
