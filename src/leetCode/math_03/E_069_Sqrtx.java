package leetCode.math_03;
/**
 * Created by Cookies
 * 69. Sqrt(x)
 */
public class E_069_Sqrtx {
    /**
     * Time:  O(logn)
     * Space: O(1)
     */
    // Binary Search:
    public static int Sqrt(int x){
        if(x <= 0) return x;
        int low = 1;
        int high = x;
        int mid, sqrt;
        while(high >= low){
            mid = low + (high - low) / 2;
             sqrt =  x / mid;
            if(sqrt == mid){
                return mid;
            } else if(sqrt < mid){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return high;

    }

    /**
     * 二分法第二种写法
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x <= 0) return 0;
        int low = 1, high = x;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        if (high * high < x) {
            return (int) high;
        } else {
            return (int) low;
        }
    }
    //Newton's Method
    /**
     * Xn+1 = Xn - f(Xn)/f'(Xn)
     * f(x) = x^2 - a = 0,  x = sqrt(a)
     * f'(x) = 2x
     *
     * X0 = a
     * Xn+1 = Xn - (Xn^2 - a) / 2Xn
     *      = (Xn + a / Xn) / 2
     */
    public static int mySqrt(int a){
        long x = a;
        while(x * x > a){
            x = (x + a / x) / 2;
        }
        return (int)x;
    }

    public static void main(String[] args) {
        int x = 12;
        int res = Sqrt(x);
        System.out.println(res);
        int res1 = mySqrt(x);
        System.out.println(res1);

    }
}

