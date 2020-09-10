package laiClass.class_02_recursive_binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class binary {

    /**
     * 经典版本
     * search 在一个sorted array里面
     * 可以用单个元素 debug
     */
    public int biSearch(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 2D的binarySearch
     *
     */
    public int[] searchIn2d(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[]{-1, -1};
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int x = mid / col;
            int y = mid % col;
            if (matrix[x][y] > target) {
                end = mid - 1;
            } else if (matrix[x][y] < target) {
                start = mid + 1;
            } else {
                return new int[] {x,y};
            }
        }
        return new int[] {-1, -1};

    }

    /**
     * 变形2
     * How to find an element in the array that is closest to the target number?
     */
    public int findClost(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                 right = mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                return mid;
            }
        }
        return Math.abs(array[left] - target) < Math.abs(array[right] - target) ? left : right;
    }

    /**
     * 变形2
     * Return the index of the first occurrence of an element, say 5
     */

    public int findFirst1(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid;    //right = mid - 1也行
            } else if (array[mid] < target) {
                left = mid;     //left = mid + 1也行
            } else {
                right  = mid;
            }
        }
        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
            return right;
        } else {
            return -1;
        }
    }

    public int findFirst2(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        while (left < right) { //因为 <= 的话会在left = right的时候陷入死循环。
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return array[right] == target ? right : -1;
    }

    public int findFirst3(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                if (mid == 0 || array[mid - 1] < target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return array[right] == target ? right : -1;
    }

    /**
     * 变形3
     * Variant1.3 Return the index of the last occurrence of an element, say 5
     */
    public int findLast(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid - 1;    //right = mid也行
            } else if (array[mid] < target) {
                left = mid + 1;     //left = mid也行
            } else {
                left = mid;
            }
        }
        if (array[right] == target) {
            return right;
        } else if (array[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    /**
     * 变形4
     * Variant 1.4 How to find k elements in the array that is closest to the target number?
     */
    public int[] findKClost(int[] array, int n, int target) {
        if (array == null || array.length == 0) return array;
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid;    // right = mid - 1不可以 会错过
            } else if (array[mid] < target) {
                left = mid;     // left = mid + 1不可以 会错过
            } else {
                left = mid; //right = mid 也可以， 没有差别
            }
        }

        while (n != 0) {
            if (left >= 0 && right <= array.length - 1) {
                if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
                    res.add(array[left--]);
                } else {
                    res.add(array[right++]);
                }
            } else if (left >= 0) {
                res.add(array[left--]);
            } else if (right <= array.length - 1) {
                res.add(array[right++]);
            }
            n--;
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }

        return ret;
    }

    /**
     * 变形5
     * // Binary Search Variant 2.0:
     * Important Question: Given a sorted dictionary with unknown size, how to determine whether a word is in this dictionary or not.
     */

    public static void main(String[] args) {
        binary a = new binary();
        int[] array = {1, 4, 5, 7, 8, 9, 10, 23, 46, 45};
        System.out.println(a.biSearch(array, 47));
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] res = a.searchIn2d(matrix, 10);
        System.out.println(Arrays.toString(res));
        int[] array1 = {2, 4, 4, 5, 6, 9, 10, 12};
        System.out.println(a.findClost(array1, 10));
        int[] array2 = {4, 4, 5, 5, 5, 5, 6, 6};
        System.out.println(a.findFirst1(array2, 5));
        System.out.println(a.findFirst2(array2, 5));
        System.out.println(a.findFirst3(array2, 5));
        System.out.println(a.findLast(array2, 5));
        int[] array3 = {0,0,1,2,3,3,4,7,7,8};
        int[] res1 = a.findKClost(array3, 4, 3);
        System.out.println(Arrays.toString(res1));
    }
}
