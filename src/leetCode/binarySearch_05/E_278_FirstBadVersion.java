package leetCode.binarySearch_05;

public class E_278_FirstBadVersion {

    boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int cur = start + (end - start) / 2;
            if (isBadVersion(cur)) {
                end = cur - 1;
            } else {
                start = cur + 1;
            }
        }
        return start;
    }
}
