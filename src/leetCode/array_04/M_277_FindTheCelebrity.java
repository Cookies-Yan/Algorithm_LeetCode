package leetCode.array_04;

public class M_277_FindTheCelebrity {

    //是的话返回label,不是的话返回-1
    public boolean knows(int a, int b) {

        return true;
    }

    public int findCelebrity(int n) {

        if (n < 2) return -1;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (knows(res, i)) {
                res = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if(res != i && (knows(res, i) || !knows(i, res))) {
                return -1;
            }
        }
        return res;
    }
}
