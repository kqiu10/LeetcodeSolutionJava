/**
 * Date: 2/27/21
 * Question Description:
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 *
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 * <p>
 * Examples:
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class _1004_MaxConsecutiveOnesIII {
    public static int longestOnes(int[] A, int K) {
        int i = 0, j = 0;
        for (; i < A.length; i++) {
            if (A[i] == 0) {
                K--;
            }
            if (K < 0) {
                if (A[j++] == 0) K++;
            }
        }
        return i - j;
    }

    public static void main(String[] args) {
        longestOnes(new int[]{1,1,1,0,0,0,1}, 2);
    }
}
