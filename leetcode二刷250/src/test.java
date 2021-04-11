/**
 * Date: 4/10/21
 * Question Description:
 * <p>
 * Examples:
 */

import java.util.ArrayList;
import java.util.Arrays;
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

    public void swapZero(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            while (arr[r] == 0) {
                r--;
            }
            if (l < r && arr[l] == 0) {
                swap(l++, r--, arr);
            }
            l++;
        }
        System.out.println(Arrays.toString(arr));
    }
    void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        test t1 = new test();
//        System.out.println( t1.findCommon(new int[]{1, 2, 5, 3, 0}, new int[]{2, 2, 0}));
        t1.swapZero(new int[]{0, 8, 9, 0, 4, 2, 0, 0});
    }
}
