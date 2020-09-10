package leetCode.binarySearch_05;

import java.util.*;

public class M_528_RandomPickWithWeight {
    Random rmd;
    int[] sum;

    public M_528_RandomPickWithWeight(int[] w) {
        this.rmd = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.sum = w;

    }

    public int pickIndex() {
        /**
         * random从0开始的，
         */
        int index = rmd.nextInt(sum[sum.length - 1]) + 1;
        int left = 0;
        int right = sum.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] == index) {
                return mid;
            } else if (sum[mid] < index){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
