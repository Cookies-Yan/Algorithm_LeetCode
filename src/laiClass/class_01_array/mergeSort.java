package laiClass.class_01_array;

import java.util.Arrays;

public class mergeSort {
    /**
     * 普通mergeSort, 视频中的mergeSort 不好实现
     * 在MergeSort中右一个在原数组基础上改的写法，时间和空间复杂度 是相同的
     * 在LC148 用linkedList 实现 mergeSort
     * @param array
     * @param left
     * @param right
     * @return
     */
    public int[] mergeSortAl(int[] array, int left, int right) {
        int[] solution = new int[right - left + 1]; //造成太大开销
        if (left == right) {
            solution[0] = array[left];
            return solution;
        }
        int mid = left + (right - left) / 2;
        int[] soluLeft = mergeSortAl(array, left, mid);
        int[] soluRigh = mergeSortAl(array, mid + 1, right);
        solution = combine(soluLeft, soluRigh);
        return solution;


    }

    public int[] combine(int[] a, int[] b) {

        int[] temp = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = b[j++];
            }
        }

        while (i < a.length) {
            temp[k++] = a[i++];
        }

        while (j < b.length) {
            temp[k++] = b[j++];
        }

        return temp;
    }

    /**
     * 变形1
     * A1B2C3D4 -> ABCD1234
     */

    public char[] mergeLetter(char[] array, int left, int right) {
        char[] store = new char[right - left + 1];
        if (left == right) {
            store[0] = array[left];
            return store;
        }
        int mid = left + (right - left) / 2;
        char[] leftRes = mergeLetter(array, left, mid);
        char[] rightRes = mergeLetter(array, mid + 1, right);
        store = combine1(leftRes, rightRes);
        return store;
    }

    public char[] combine1(char[] a, char[] b) {
        char[] temp = new char[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {

            if (Character.isLetter(a[i])) {
                if (Character.isLetter(b[j]) && a[i] - b[j] > 0) {
                    temp[k++] = b[j++];
                } else {
                    temp[k++] = a[i++];
                }
            } else {
                if (Character.isDigit(b[j]) && a[i] - b[j] < 0) {
                    temp[k++] = a[i++];
                } else {
                    temp[k++] = b[j++];
                }
            }
        }

        while (i < a.length) {
            temp[k++] = a[i++];
        }

        while (j < b.length) {
            temp[k++] = b[j++];
        }
        return temp;
    }

    /**
     * 变形2
     * ABCD1234 -> A1B2C3D4
     * 方案1，还是mergeSort; 很麻烦
     * 反着 run mergeSort
     */
    public String mergeReverse(String s, int left, int right) {
        String sb = "";

        if (left == right) {
            sb = sb + s.charAt(left);
            return sb;
        }

        int mid = left + (right - left) / 2;
        s = reverse1(s,  left,  right);
        String sL = mergeReverse(s, left, mid);
        String sR = mergeReverse(s, mid + 1, right);
        sb = combine2(sL, sR);
        return sb;
    }

    public String combine2(String a, String b) {
        StringBuilder sb1 = new StringBuilder();
        boolean done = true;
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (done) {
                if (Character.isLetter(a.charAt(i))) {
                    if (Character.isLetter(b.charAt(j)) && a.charAt(i) - b.charAt(j) > 0) {
                        sb1.append(b.charAt(j++));
                    } else {
                        sb1.append(a.charAt(i++));
                    }
                } else {
                    sb1.append(b.charAt(j++));
                }
                done = !done;
            } else {
                if (Character.isDigit(a.charAt(i))) {
                    if (Character.isDigit(b.charAt(j)) && a.charAt(i) - b.charAt(j) > 0) {
                        sb1.append(b.charAt(j++));
                    } else {
                        sb1.append(a.charAt(i++));
                    }
                } else {
                    sb1.append(b.charAt(j++));
                }
                done = !done;
            }
        }
        while (i < a.length()) {
           sb1.append(a.charAt(i++));
        }
        while (j < b.length()) {
            sb1.append(b.charAt(j++));
        }
        return sb1.toString();
    }

    public String reverse1(String a, int left, int right) {
        if (right - left <= 1) {
            return a;
        }
        int size = right - left + 1;
        int mid = left + size / 2;
        int leftMid = left + size / 4;
        int rightMid = left + size * 3 / 4;

        a = reverse(a, leftMid, mid - 1);
        a = reverse(a, mid, rightMid - 1);
        return reverse(a, leftMid, rightMid - 1);
    }

    /**
     * 变形2
     * ABCD1234 -> A1B2C3D4
     * 方案2
     * 反着 run mergeSort
     */
    public String convert (String a, int left, int right) {
        if (right - left <= 1) {
            return a;
        }
        int size = right - left + 1;
        int mid = left + size / 2;
        int leftMid = left + size / 4;
        int rightMid = left + size * 3 / 4;

        a = reverse(a, leftMid, mid - 1);
        a = reverse(a, mid, rightMid - 1);
        a = reverse(a, leftMid, rightMid - 1);

        a = convert(a, left, left + 2 * (leftMid - left) - 1);
        return convert(a, left + 2 * (leftMid - left), right);

    }

    public String reverse(String target, int left, int right) {
        if (left >= right) {
            return target;
        }
        target = swap(target, left, right);
        return reverse(target, left + 1, right - 1);
    }

    public String swap(String s, int left, int right) {
        char[] c = s.toCharArray();
        char temp = c[left];
        c[left] = c[right];
        c[right] = temp;
        return String.valueOf(c);
    }


    public static void main(String[] args) {
        mergeSort a = new mergeSort();
        int[] test = {1, 3, 5, 7, 9, 8, 6, 4, 9, 0};
        System.out.println(Arrays.toString(a.mergeSortAl(test, 0, test.length - 1)));
        char[] test1 = {'A', '1', 'B', '2', 'C', '3', 'D', '4'};
        char[] res = a.mergeLetter(test1, 0, test1.length - 1);
        System.out.println(Arrays.toString(res));
        String test2 = "ABCD1234";
        System.out.println(a.convert(test2, 0, test2.length() - 1));
        String ret = a.mergeReverse(test2, 0, test2.length() - 1);
        System.out.println(ret);

    }
}
