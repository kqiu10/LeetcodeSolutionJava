package leetcode.Mathmatics数学题;
/**
 * Package Name : leetcode.Mathmatics数学题;
 * File name : FizzBuzz;
 * Creator: Kane;
 * Date: 7/28/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class FizzBuzz412 {
    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        if ( n == 0) return res;
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(i + "");
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }
}
