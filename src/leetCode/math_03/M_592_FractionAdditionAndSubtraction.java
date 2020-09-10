package leetCode.math_03;

import java.util.Scanner;

/**
 * Time O(n)
 * Space O(1)
 */
public class M_592_FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])");
        int A = 0, B = 1;
        while (sc.hasNext()) {
            int a = sc.nextInt(), b = sc.nextInt();
            A = A * b + a * B;
            B *= b;
            int g = gcd(A, B);
            A /= g;
            B /= g;
        }
        return A + "/" + B;
    }

    public static int gcd(int a, int b) {
        if (a == 0) return Math.abs(b);
        return gcd(b % a, a);
    }
}
