package leetCode.math_03;

/**
 * Time O(sqrt(n))
 * Space O(1)
 */
public class E_492_ConstructTheRectangle {

    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (area % w != 0) {
            w--; //L >= W
        }
        return new int[]{area / w, w};
    }
}
