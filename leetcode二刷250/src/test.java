/**
 * Date: 4/10/21
 * Question Description:
 * <p>
 * Examples:
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class test {
    public List<Integer> findCommon(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int val : arr1) {
            set.add(val);
        }
        for (int val : arr2) {
            if (!set.add(val)) {
                res.add(val);
            }
        }
        return new ArrayList<Integer>(res);
    }

    public static void main(String[] args) {
        test t1 = new test();
        System.out.println( t1.findCommon(new int[]{1, 2, 5, 3, 0}, new int[]{2, 2, 0}));

    }
}
