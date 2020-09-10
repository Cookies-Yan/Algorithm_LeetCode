package leetCode.math_03;

/**
 * 只需要求n前面有几个完全平方数
 * 奇数次打开
 * 偶数次关闭
 * 12 : 1 12 2 6 3 4
 */
public class NotIm_319_BulbSwitcher {
    /**
     * Time O(1)
     * Space O(1)
     * @param n
     * @return
     */
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
