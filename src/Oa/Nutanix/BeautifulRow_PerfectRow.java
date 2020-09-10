package Oa.Nutanix;

/**
 * A farmer has n trees in a row in his garden. He thinks, that a row of trees is beautiful if heights of trees in it are first increasing, then decreasing. For example, 2 5 6 3 is a beautiful row whereas 1 3 4 2 5 is not a beautiful row. The row of trees in farmers garden may not be beautiful. Help the farmer, cut down the minimum number of trees to make the row beautiful.
 * A row, sorted in increasing order and without any decreasing part is considered beautiful.
 * A row, sorted in decreasing order and without any increasing part is considered beautiful.
 *
 *Input
 * The first line of input contains integer n.
 * The second line of input contains n space-separated integers - k1, k2, k3 ,...,kn.
 *
 * Output
 * Print the value, representing the minimum number of trees you need to cut down to make a row beautiful.
 *
 * Constraints
 * 1 <= n <= 1000.
 * 1 <= ki < 1000000.
 *
 * Example#1
 * Input
 * 8
 * 3 17 4 12 5 6 2 1
 * Output
 * 2
 * We can cut down 17 and 5.
 *
 * Example#2
 * Input
 * 4
 * 1 2 100 99
 * Output
 * 0
 * This row is already beautiful.
 */
public class BeautifulRow_PerfectRow {

    public static int lbs(int nums[], int n) {
        int i, j;

        /* Allocate memory for LIS[] and initialize LIS values as 1 for
            all indexes */
        int[] lis = new int[n];
        for (i = 0; i < n; i++) {
            lis[i] = 1;
        }

        /* Compute LIS values from left to right */
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }
        /* Allocate memory for lds and initialize LDS values for
            all indexes */
        int[] lds = new int [n];
        for (i = 0; i < n; i++)
            lds[i] = 1;

        /* Compute LDS values from right to left */
        for (i = n-2; i >= 0; i--)
            for (j = n-1; j > i; j--)
                if (nums[i] > nums[j] && lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;


        /* Return the maximum value of lis[i] + lds[i] - 1*/
        int max = lis[0] + lds[0] - 1;
        for (i = 1; i < n; i++)
            if (lis[i] + lds[i] - 1 > max)
                max = lis[i] + lds[i] - 1;

        return n - max;

    }
    public static void main (String[] args)
    {
        int arr[] = {1,2,100,99};
        int n = arr.length;
        System.out.println(lbs( arr, n ));
    }
}
