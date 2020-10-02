package leetcode.Mathmatics数学题;
/**
 * Package Name : leetcode.Mathmatics数学题;
 * File name : _592_FractionAdditionAndSubtraction;
 * Creator: Kane;
 * Date: 7/28/20
 */

import java.util.Scanner;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class _592_FractionAdditionAndSubtraction {
    public static String fractionAddition(String expression) {
        Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])");
        int A = 0, B = 1;
        while(sc.hasNext()) {
            int a = sc.nextInt(), b = sc.nextInt();
            A = A*b + B*a;
            B = B * b;
            int gcd = gcd(A,B);
            A /= gcd;
            B /= gcd;
        }
        return  A+ "/" + B;

    }
    public static int gcd(int a, int b) {
        if (a == 0) return Math.abs(b);
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        String st = "1/3-1/2";
        fractionAddition(st);
    }
}
