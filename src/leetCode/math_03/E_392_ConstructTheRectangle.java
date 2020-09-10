package leetCode.math_03;

public class E_392_ConstructTheRectangle {

    /**
     * Time O(sqrt(n)
     * Space O(1)
     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (area % w != 0) {
            w--;
        }
        return new int[]{area / w, w};
    }
}
