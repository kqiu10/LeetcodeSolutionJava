/**
 * Date: 11/27/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _264_UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] list = new int[n];
        int factor2 = 0, factor3 = 0, factor5 = 0;
        list[0] = 1;
        for (int i = 1; i < n; i++) {
            list[i] = Math.min(list[factor2] * 2, Math.min(list[factor3] * 3, list[factor5] *5 ));
            if (list[i] % 2 == 0) factor2++;
            if (list[i] % 3 == 0) factor3++;
            if (list[i] % 5 == 0) factor5++;
        }
        return list[n - 1];


    }
}
