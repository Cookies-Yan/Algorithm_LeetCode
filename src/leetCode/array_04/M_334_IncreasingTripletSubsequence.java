package leetCode.array_04;

public class M_334_IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num < secondMin) {
                secondMin = num;
            } else if (num > secondMin) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,5,5,2,5,4};
        System.out.println(increasingTriplet(nums));
    }

}
