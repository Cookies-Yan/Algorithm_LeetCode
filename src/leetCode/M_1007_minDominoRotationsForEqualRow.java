package leetCode;

public class M_1007_minDominoRotationsForEqualRow {

    public static int minDominoRotations(int[] A, int[] B) {

        if (A == null || B == null || A.length != B.length) return -1;


        int res = helper(A[0], A, B);
        if (res != -1 || A[0] == B[0]) return res;
        else return helper(B[0], A, B);

    }

    public static int helper(int num, int[] A, int[] B){
        int pick_a = 0;
        int pick_b = 0;

        for(int i = 0; i < A.length; i++) {
            if (A[i] != num && B[i] != num) return -1;
            if (A[i] != num) pick_a++;
            if (B[i] != num) pick_b++;
        }

        return Math.min(pick_a, pick_b);
    }


    public static void main(String[] args) {
        int[] A = new int[]{2, 1, 2, 4, 2, 2};
        int[] B = new int[]{5, 2, 6, 2, 3, 2};
        System.out.println(minDominoRotations(A, B));
    }
}
