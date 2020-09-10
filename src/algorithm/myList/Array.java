package algorithm.myList;

import java.util.Arrays;

public class Array {

    public static void array() {
        int[] arr1 = new int[10];
        int[] array = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(array));
        array[0] = 2;
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {

        }

        for (int arr : array) {

        }

        int[][] array2 = new int[][] {

                {1, 2, 3},
                {1, 2, 3}

        };
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2.length; j++) {


            }

        }

        array2[1][1] = 3;

    }

    public static void main(String[] args) {
        array();

    }
}

