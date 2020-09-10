package leetCode.binarySearch_05;

public class E_374_GuessNumberHigherOrLower {

    /**
     * Time O(logn)
     * Space O()
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (guess(mid) == -1) {
                end = mid;
            } else if (guess(mid) == 1) {
                start = mid;
            } else {
                return mid;
            }
        }
        if (guess(start) == 0) return start;
        return end;
    }

    public int guess(int n) { //防止编译出错
        return 0;
    }
}
