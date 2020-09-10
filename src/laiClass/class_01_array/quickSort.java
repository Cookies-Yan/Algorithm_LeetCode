package laiClass.class_01_array;

import java.util.Arrays;

public class quickSort {

    /**
     * 普通的quickSort
     * @param array
     * @param left
     * @param right
     */
    public void quick(int[] array, int left, int right) {
        if (left < right) {
            int pivot = helper(array, left, right);
            quick(array, left, pivot - 1);
            quick(array, pivot + 1, right);
        }
    }

    public int helper(int[] array, int left, int right) {
        int p = left;
        int l = left + 1;
        int r = right;

        while (l <= r) { //必须小于等于
            if (array[l] > array[p] && array[r] < array[p]) {
                swap(array, l++, r--);
            }
            if (array[l] <= array[p]) {
                l++;
            }
            if (array[r] >= array[p]){
                r--;
            }
        }
        swap(array, p, r);
        return r;
    }

    /**
     * 变形1
     * Rainbow sort (b a c c c a b b a b b a c a a -> aaaaa bbbbb ccccc)
     *               a a a a a a b b b b b c c c c
     *                           i
     *                                   j
     *                                   k
     * 		(3个挡板, 4个区域, 同向 + 相向而行)
     */
    public String rainbowSort(String s, int left, int right) {

        if (s.equals("") || s.length() == 0) return "";
        int i = left, j = left + 1, k = right;
        char[] temp = s.toCharArray();
        while (j <= k) {
            if (temp[j] == 'a') {
                swap1(temp, i++, j++);
            } else if (temp[j] =='b') {
                j++;
            } else {
                swap1(temp, j, k--);
            }
        }
        return String.valueOf(temp);
    }


    public void swap1(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }



    public static void main(String[] args) {
        quickSort a = new quickSort();
        int[] b = {1, 1, 3, 5, 7, 9, 8, 6, 4, 2, 0};
        a.quick(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b));
        String ss = "abcccabbcbbacaa";
        ss = a.rainbowSort(ss, 0, ss.length() - 1);
        System.out.println(ss);
        /**
         * 二维数组或者高维数组当中，除了最后一维，剩下的每一维都是指向下一维数组的一个reference
         * 只有最低那一维如果它是int，那才是默认值为0
         * 如果我现在在一个比较高的维上的话，那就是一个 指向数组的reference, 而reference在java中的默认值是null
         */
        int[][] array = new int[5][]; //{null, null, null, null, null}
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }
}
