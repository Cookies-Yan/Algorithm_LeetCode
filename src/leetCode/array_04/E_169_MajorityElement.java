package leetCode.array_04;

/**
 * 利用数学定理
 * Moore voting algorithm
 * 每次都找出一对不同的元素，从数组中删掉，知道数组为空或者只有一种元素
 * 不难证明，如果存在元素e出现频率超过半数，那么数组中最后剩下的就只有e.
 */
public class E_169_MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {

            if (count == 0) {
                res = num;
            }
            if (num != res) {
                count--;
            } else {
                count++;
            }
        }
        return res;
    }
}
